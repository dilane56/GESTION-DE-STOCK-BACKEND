package org.kfokam48.gestiondestockbackend.service;

import org.kfokam48.gestiondestockbackend.dto.CommandeFournisseurDto;
import org.kfokam48.gestiondestockbackend.model.CommandeFournisseur;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CommandeFournisseurService {
    CommandeFournisseur getCommandeFournisseurById(Long id);
    CommandeFournisseur addCommandeFournisseur(CommandeFournisseurDto commandeFournisseurDto);
    CommandeFournisseur updateCommande(Long id, CommandeFournisseurDto dto);
    ResponseEntity<String> deleteCommande(Long id);
    CommandeFournisseur getCommandeByCode(String code);
    List<CommandeFournisseur> getAllCommandeFournisseur();


}
