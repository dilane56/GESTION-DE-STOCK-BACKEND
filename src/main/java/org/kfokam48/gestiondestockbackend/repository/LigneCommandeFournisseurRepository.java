package org.kfokam48.gestiondestockbackend.repository;

import org.kfokam48.gestiondestockbackend.model.LigneCommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneCommandeFournisseurRepository extends JpaRepository<LigneCommandeFournisseur, Long> {
}
