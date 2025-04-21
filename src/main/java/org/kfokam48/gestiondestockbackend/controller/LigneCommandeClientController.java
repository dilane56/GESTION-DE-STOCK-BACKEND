package org.kfokam48.gestiondestockbackend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.kfokam48.gestiondestockbackend.dto.LigneCommandeClientDto;
import org.kfokam48.gestiondestockbackend.model.LigneCommandeClient;
import org.kfokam48.gestiondestockbackend.service.LigneCommandeClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ligneCommandeClients")
public class LigneCommandeClientController {

    private final LigneCommandeClientService ligneCommandeClientService;

    public LigneCommandeClientController(LigneCommandeClientService ligneCommandeClientService) {
        this.ligneCommandeClientService = ligneCommandeClientService;
    }

    @Operation(summary = "Créer une ligne de commande client", description = "Ajoute une nouvelle ligne de commande client en base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ligne de commande client créée avec succès"),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })
    @PostMapping
    public ResponseEntity<LigneCommandeClient> createLigneCommandeClient(@Valid @RequestBody LigneCommandeClientDto lc) {
        LigneCommandeClient ligneCommandeClient = ligneCommandeClientService.addLigneCommandeClient(lc);
        return ResponseEntity.status(HttpStatus.CREATED).body(ligneCommandeClient);
    }

    @Operation(summary = "Récupérer une ligne de commande client par ID", description = "Retourne une ligne de commande client spécifique en fonction de son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ligne de commande client récupérée avec succès"),
            @ApiResponse(responseCode = "404", description = "Ligne de commande client introuvable")
    })
    @GetMapping("/{id}")
    public ResponseEntity<LigneCommandeClient> getLigneCommandeClientById(@PathVariable Long id) {
        LigneCommandeClient ligneCommandeClient = ligneCommandeClientService.getLigneCommandeClient(id);
        return ResponseEntity.ok(ligneCommandeClient);
    }

    @Operation(summary = "Récupérer toutes les lignes de commande client", description = "Retourne la liste de toutes les lignes de commande client en base de données.")
    @ApiResponse(responseCode = "200", description = "Liste des lignes de commande client récupérée avec succès")
    @GetMapping
    public ResponseEntity<List<LigneCommandeClient>> getAllLigneCommandeClients() {
        List<LigneCommandeClient> lignes = ligneCommandeClientService.getAllLigneCommandeClient();
        return ResponseEntity.ok(lignes);
    }

    @Operation(summary = "Mettre à jour une ligne de commande client", description = "Modifie une ligne de commande client existante en base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ligne de commande client mise à jour avec succès"),
            @ApiResponse(responseCode = "404", description = "Ligne de commande client introuvable"),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })
    @PutMapping("/{id}")
    public ResponseEntity<LigneCommandeClient> updateLigneCommandeClient(@PathVariable Long id, @Valid @RequestBody LigneCommandeClientDto lc) {
        LigneCommandeClient updatedLigneCommandeClient = ligneCommandeClientService.updateLigneCommandeClient(id, lc);
        return ResponseEntity.ok(updatedLigneCommandeClient);
    }

    @Operation(summary = "Supprimer une ligne de commande client", description = "Supprime une ligne de commande client en fonction de son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ligne de commande client supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "Ligne de commande client introuvable")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLigneCommandeClient(@PathVariable Long id) {
        return ligneCommandeClientService.deleteLigneCommandeClient(id);
    }
}