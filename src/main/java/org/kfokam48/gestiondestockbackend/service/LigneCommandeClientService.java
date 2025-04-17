package org.kfokam48.gestiondestockbackend.service;

import org.kfokam48.gestiondestockbackend.dto.LigneCommandeClientDto;
import org.kfokam48.gestiondestockbackend.model.LigneCommandeClient;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LigneCommandeClientService {
    LigneCommandeClient getLigneCommandeClient(Long id) ;
    List<LigneCommandeClient> getAllLigneCommandeClient();
    LigneCommandeClient addLigneCommandeClient(LigneCommandeClientDto lc);
    ResponseEntity<String> deleteLigneCommandeClient(Long id);
    LigneCommandeClient updateLigneCommandeClient(Long id,LigneCommandeClientDto lc);
}
