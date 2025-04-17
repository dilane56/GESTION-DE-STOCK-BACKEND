package org.kfokam48.gestiondestockbackend.service;

import org.kfokam48.gestiondestockbackend.dto.LigneVenteDto;
import org.kfokam48.gestiondestockbackend.model.LigneVente;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LigneVenteService {

    LigneVente getLigneVenteById(Long id);
    List<LigneVente> getLigneVentes();
    LigneVente save(LigneVenteDto ligneVenteDto);
    ResponseEntity<String> delete(Long id);
    LigneVente update(Long id, LigneVenteDto ligneVenteDto);

}
