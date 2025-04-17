package org.kfokam48.gestiondestockbackend.repository;

import org.kfokam48.gestiondestockbackend.model.CommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeFournisseurRepository extends JpaRepository<CommandeFournisseur, Long> {
    CommandeFournisseur findByCode(String code);
}
