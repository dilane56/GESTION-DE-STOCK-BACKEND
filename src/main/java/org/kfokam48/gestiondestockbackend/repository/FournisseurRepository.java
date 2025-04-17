package org.kfokam48.gestiondestockbackend.repository;

import org.kfokam48.gestiondestockbackend.model.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {
}
