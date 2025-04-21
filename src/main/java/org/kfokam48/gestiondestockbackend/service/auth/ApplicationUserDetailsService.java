package org.kfokam48.gestiondestockbackend.service.auth;

import org.kfokam48.gestiondestockbackend.model.Utilisateur;
import org.kfokam48.gestiondestockbackend.repository.UtilisateurRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class ApplicationUserDetailsService implements UserDetailsService {
    private final UtilisateurRepository userRepository;

    public ApplicationUserDetailsService(UtilisateurRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Ici, vous pouvez charger l'utilisateur à partir de votre base de données
        Utilisateur user = userRepository.findByEmail(username).orElseThrow(()->
                new UsernameNotFoundException("User not found"));
        return null;
    }

//    public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException {
//        return userRepository.findByEmail(email)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
//    }


}
