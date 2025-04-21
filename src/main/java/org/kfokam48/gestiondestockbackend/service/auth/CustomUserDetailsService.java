package org.kfokam48.gestiondestockbackend.service.auth;

import org.kfokam48.gestiondestockbackend.model.CustomUserDetails;
import org.kfokam48.gestiondestockbackend.model.Roles;
import org.kfokam48.gestiondestockbackend.model.Utilisateur;
import org.kfokam48.gestiondestockbackend.repository.UtilisateurRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UtilisateurRepository userRepository;

    public CustomUserDetailsService(UtilisateurRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur user = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur introuvable : " + username));
        return new CustomUserDetails(user.getEmail(), user.getPassword(), getAuthorities(user.getRoles()));
    }

    private List<GrantedAuthority> getAuthorities (List<Roles> rolesList) {
        // Ajout automatique du préfixe "ROLE_" pour la sécurité Spring.
        // Ici, nous supposons que rolesList contient des objets de type Roles
        // qui ont une méthode getRoleName() pour obtenir le nom du rôle.
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Roles role : rolesList) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return authorities;
    }

}
