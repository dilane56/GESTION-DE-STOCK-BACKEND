package org.kfokam48.gestiondestockbackend.controller;

import jakarta.validation.Valid;
import org.kfokam48.gestiondestockbackend.dto.CommandeClientDto;
import org.kfokam48.gestiondestockbackend.model.CommandeClient;
import org.kfokam48.gestiondestockbackend.service.CommandeClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commandeClients")
public class CommandeClientController {

    private final CommandeClientService commandeClientService;

    public CommandeClientController(CommandeClientService commandeClientService) {
        this.commandeClientService = commandeClientService;
    }

    @PostMapping
    public ResponseEntity<CommandeClient> createCommandeClient(@Valid @RequestBody CommandeClientDto commandeClientDto) {
        CommandeClient commandeClient = commandeClientService.addCommandeClient(commandeClientDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(commandeClient);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommandeClient> getCommandeClientById(@PathVariable Long id) {
        CommandeClient commandeClient = commandeClientService.getCommandeClientById(id);
        return ResponseEntity.ok(commandeClient);
    }

    @GetMapping
    public ResponseEntity<List<CommandeClient>> getAllCommandeClients() {
        List<CommandeClient> commandes = commandeClientService.getAllCommandeClients();
        return ResponseEntity.ok(commandes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommandeClient> updateCommandeClient(@PathVariable Long id, @Valid @RequestBody CommandeClientDto commandeClientDto) {
        CommandeClient updatedCommandeClient = commandeClientService.updateCommandeClient(id, commandeClientDto);
        return ResponseEntity.ok(updatedCommandeClient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCommandeClient(@PathVariable Long id) {
        return commandeClientService.deleteCommandeClient(id);
    }
}