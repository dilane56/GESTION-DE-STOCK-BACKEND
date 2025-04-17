package org.kfokam48.gestiondestockbackend.service;

import org.kfokam48.gestiondestockbackend.dto.MvtStkDto;
import org.kfokam48.gestiondestockbackend.model.MvtStk;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MvtStkService {

    MvtStk getMvtStkById(Long id);
    List<MvtStk> getMvtStkList();
    MvtStk createMvtStk(MvtStkDto mvtStkDto);
    ResponseEntity<String> deleteMvtStkById(Long id);
    MvtStk updateMvtStk(Long id,MvtStkDto mvtStkDto);
}
