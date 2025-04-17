package org.kfokam48.gestiondestockbackend.repository;

import org.kfokam48.gestiondestockbackend.model.MvtStk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MvtStkRepository extends JpaRepository<MvtStk, Long> {
}
