package org.kfokam48.gestiondestockbackend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Créer une commande client", description = "Ajoute une nouvelle commande client en base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Commande client créée avec succès"),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })
    @PostMapping
    public ResponseEntity<CommandeClient> createCommandeClient(@Valid @RequestBody CommandeClientDto commandeClientDto) {
        CommandeClient commandeClient = commandeClientService.addCommandeClient(commandeClientDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(commandeClient);
    }

    @Operation(summary = "Récupérer une commande client par ID", description = "Retourne une commande client spécifique en fonction de son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Commande client récupérée avec succès"),
            @ApiResponse(responseCode = "404", description = "Commande client introuvable")
    })
    @GetMapping("/{id}")
    public ResponseEntity<CommandeClient> getCommandeClientById(@PathVariable Long id) {
        CommandeClient commandeClient = commandeClientService.getCommandeClientById(id);
        return ResponseEntity.ok(commandeClient);
    }

    @Operation(summary = "Récupérer toutes les commandes clients", description = "Retourne la liste de toutes les commandes clients en base de données.")
    @ApiResponse(responseCode = "200", description = "Liste des commandes clients récupérée avec succès")
    @GetMapping
    public ResponseEntity<List<CommandeClient>> getAllCommandeClients() {
        List<CommandeClient> commandes = commandeClientService.getAllCommandeClients();
        return ResponseEntity.ok(commandes);
    }

    @Operation(summary = "Mettre à jour une commande client", description = "Modifie une commande client existante en base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Commande client mise à jour avec succès"),
            @ApiResponse(responseCode = "404", description = "Commande client introuvable"),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })
    @PutMapping("/{id}")
    public ResponseEntity<CommandeClient> updateCommandeClient(@PathVariable Long id, @Valid @RequestBody CommandeClientDto commandeClientDto) {
        CommandeClient updatedCommandeClient = commandeClientService.updateCommandeClient(id, commandeClientDto);
        return ResponseEntity.ok(updatedCommandeClient);
    }

    @Operation(summary = "Supprimer une commande client", description = "Supprime une commande client en fonction de son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Commande client supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "Commande client introuvable")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCommandeClient(@PathVariable Long id) {
        return commandeClientService.deleteCommandeClient(id);
    }
}