package org.kfokam48.gestiondestockbackend.service;

import org.kfokam48.gestiondestockbackend.dto.FournisseurDto;
import org.kfokam48.gestiondestockbackend.model.Fournisseur;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FournisseurService {

    Fournisseur getFournisseurById(Long id);
    List<Fournisseur> getAllFournisseur();
    Fournisseur saveFournisseur(FournisseurDto fournisseurDto);
    ResponseEntity<String> deleteFournisseur(Long id);
    Fournisseur updateFournisseur(Long id ,FournisseurDto fournisseurDto);

}
