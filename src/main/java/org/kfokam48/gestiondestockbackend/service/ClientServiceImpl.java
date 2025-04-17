package org.kfokam48.gestiondestockbackend.service;

import jakarta.validation.Valid;
import org.kfokam48.gestiondestockbackend.dto.ClientDto;
import org.kfokam48.gestiondestockbackend.exception.RessourceNotFoundException;
import org.kfokam48.gestiondestockbackend.mapper.ClientMapper;
import org.kfokam48.gestiondestockbackend.model.Client;
import org.kfokam48.gestiondestockbackend.repository.ClientRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientServiceImpl(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public Client saveClient(@Valid ClientDto clientDto) {
        return clientRepository.save(clientMapper.clientDtoToClient(clientDto)) ;
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id).orElseThrow(()-> new RessourceNotFoundException("Client  with id : "+id+"not found"));
    }

    @Override
    public Client update(Long id, ClientDto clientDto) {
        Client client = clientRepository.findById(id).orElseThrow(()-> new RessourceNotFoundException("Client  with id : "+id+"not found"));
        client.setCommandes(clientMapper.commandeClientDtoListToCommandeClientList(clientDto.getCommandes()));
        client.setMail(clientDto.getMail());
        client.setNom(clientDto.getNom());
        client.setPrenom(clientDto.getPrenom());
        client.setPhoto(clientDto.getPhoto());
        client.setNumTel(clientDto.getNumTel());
        clientRepository.save(client);

        return client;
    }

    @Override
    public ResponseEntity<String> delete(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(()-> new RessourceNotFoundException("Client  with id : "+id+"not found"));
       clientRepository.delete(client);
        return ResponseEntity.ok("Client with id : "+id+" deleted successfully");
    }
}
