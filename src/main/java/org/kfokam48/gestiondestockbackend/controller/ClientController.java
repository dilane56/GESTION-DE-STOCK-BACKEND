package org.kfokam48.gestiondestockbackend.controller;

import jakarta.validation.Valid;
import org.kfokam48.gestiondestockbackend.dto.ClientDto;
import org.kfokam48.gestiondestockbackend.model.Client;
import org.kfokam48.gestiondestockbackend.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@Valid @RequestBody ClientDto clientDto) {
        Client client = clientService.saveClient(clientDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(client);
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = clientService.findAll();
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        Client client = clientService.findById(id);
        return ResponseEntity.ok(client);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @Valid @RequestBody ClientDto clientDto) {
        Client updatedClient = clientService.update(id, clientDto);
        return ResponseEntity.ok(updatedClient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Long id) {
        return clientService.delete(id);
    }

}
