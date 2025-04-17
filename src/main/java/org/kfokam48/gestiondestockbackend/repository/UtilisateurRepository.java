package org.kfokam48.gestiondestockbackend.repository;

import org.kfokam48.gestiondestockbackend.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
}
