package org.kfokam48.gestiondestockbackend.config;


import org.kfokam48.gestiondestockbackend.service.auth.ApplicationUserDetailsService;
import org.kfokam48.gestiondestockbackend.service.auth.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration  {

    private final JwtRequestFillter jwtRequestFilter;
    private ApplicationUserDetailsService applicationUserDetailsService;

    public SecurityConfiguration(JwtRequestFillter jwtRequestFilter) {
        this.jwtRequestFilter = jwtRequestFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers( "/api/v1/auth/login", "/v3/api-docs/**",
                                "/swagger-ui/**", "/swagger-resources/**", "/webjars/**","/utilisateurs").permitAll()
                        .anyRequest().authenticated())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
              //  .headers(headers -> headers.frameOptions().disable());//uniquement lors de l'utilisation d'un BD H2
        return http.build();
    }


    @Bean
    public AuthenticationManager authManager(HttpSecurity http, CustomUserDetailsService customUserDetailsService) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(customUserDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder()) // Assurez-vous que le mot de passe est encodé
                .and()
                .build();
    }

}
