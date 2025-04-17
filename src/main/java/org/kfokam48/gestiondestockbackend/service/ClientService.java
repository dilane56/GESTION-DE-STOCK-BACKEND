package org.kfokam48.gestiondestockbackend.service;

import org.kfokam48.gestiondestockbackend.dto.ClientDto;
import org.kfokam48.gestiondestockbackend.model.Client;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ClientService {

    Client  saveClient(ClientDto clientDto);
    List<Client> findAll();
    Client  findById(Long id);
    Client update(Long id, ClientDto clientDto);
    ResponseEntity<String> delete(Long id);


}
