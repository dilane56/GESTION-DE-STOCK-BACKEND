package org.kfokam48.gestiondestockbackend.config;

import org.kfokam48.gestiondestockbackend.model.Roles;
import org.kfokam48.gestiondestockbackend.model.Utilisateur;
import org.kfokam48.gestiondestockbackend.repository.RolesRepository;
import org.kfokam48.gestiondestockbackend.repository.UtilisateurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {
    private UtilisateurRepository utilisateurRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public DataInitializer(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Utilisateur user = new Utilisateur();
        user.setNom("admin");
        user.setPrenom("admin");
        user.setEmail("admin@gmail.com");
        user.setPassword(passwordEncoder.encode("admin"));
        List<Roles> roles = new ArrayList<>();
        Roles role = new Roles();
        role.setRoleName("ADMIN");
        roles.add(role);
        user.setRoles(roles);
        utilisateurRepository.save(user);

    }
}
