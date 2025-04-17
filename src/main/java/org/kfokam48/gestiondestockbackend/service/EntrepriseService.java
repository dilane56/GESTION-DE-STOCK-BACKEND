package org.kfokam48.gestiondestockbackend.service;

import org.kfokam48.gestiondestockbackend.dto.EntrepriseDto;
import org.kfokam48.gestiondestockbackend.model.Entreprise;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EntrepriseService {
    Entreprise getEntrepriseById(Long id);
    List<Entreprise> getAllEntreprises();
    Entreprise addEntreprise(EntrepriseDto ent);
    Entreprise updateEntreprise(Long id ,EntrepriseDto entrepriseDto);
    ResponseEntity<String> deleteEntreprise(Long id);
}
