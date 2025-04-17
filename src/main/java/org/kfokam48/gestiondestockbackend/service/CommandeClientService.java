package org.kfokam48.gestiondestockbackend.service;

import org.kfokam48.gestiondestockbackend.dto.CommandeClientDto;
import org.kfokam48.gestiondestockbackend.model.CommandeClient;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CommandeClientService {
    CommandeClient getCommandeClientById(Long id);
    CommandeClient findCommandeByCode(String code);
    List<CommandeClient> getAllCommandeClients();
    CommandeClient addCommandeClient(CommandeClientDto commandeClientDto);
    CommandeClient updateCommandeClient(Long id, CommandeClientDto commandeClientDto);
    ResponseEntity<String> deleteCommandeClient(Long id);
}
