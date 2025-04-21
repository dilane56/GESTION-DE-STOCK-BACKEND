package org.kfokam48.gestiondestockbackend.repository;

import org.kfokam48.gestiondestockbackend.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
  //  Utilisateur findByLogin(String login);

    Optional<Utilisateur> findByEmail(String email);

//    boolean existsByLogin(String login);
//
//    boolean existsByEmail(String email);
}
