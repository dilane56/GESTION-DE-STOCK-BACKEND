package org.kfokam48.gestiondestockbackend.service;

import org.kfokam48.gestiondestockbackend.dto.LigneCommandeFournisseurDto;
import org.kfokam48.gestiondestockbackend.model.LigneCommandeFournisseur;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LigneCommandeFournisseurService {

    LigneCommandeFournisseur findById(Long id);
    List<LigneCommandeFournisseur> findAll();
    ResponseEntity<String> deleteById(Long id);
    LigneCommandeFournisseur save(LigneCommandeFournisseurDto entity);
    LigneCommandeFournisseur update(Long id,LigneCommandeFournisseurDto entity);
}
