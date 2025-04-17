package org.kfokam48.gestiondestockbackend.service;

import org.kfokam48.gestiondestockbackend.dto.VentesDto;
import org.kfokam48.gestiondestockbackend.model.Ventes;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface VentesService {

    Ventes findVenteById(Long id);
    Ventes findVenteByCode(String code);
    List<Ventes> findAllVentes();
    Ventes saveVente(VentesDto ventesDto);
    Ventes updateVente(Long id, VentesDto ventesDto);
    ResponseEntity<String> deleteVente(Long id);
}
