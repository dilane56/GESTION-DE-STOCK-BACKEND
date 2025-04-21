package org.kfokam48.gestiondestockbackend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.kfokam48.gestiondestockbackend.dto.LigneVenteDto;
import org.kfokam48.gestiondestockbackend.model.LigneVente;
import org.kfokam48.gestiondestockbackend.service.LigneVenteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ligneVentes")
public class LigneVenteController {

    private final LigneVenteService ligneVenteService;

    public LigneVenteController(LigneVenteService ligneVenteService) {
        this.ligneVenteService = ligneVenteService;
    }

    @Operation(summary = "Créer une ligne de vente", description = "Ajoute une nouvelle ligne de vente en base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ligne de vente créée avec succès"),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })
    @PostMapping
    public ResponseEntity<LigneVente> createLigneVente(@Valid @RequestBody LigneVenteDto ligneVenteDto) {
        LigneVente ligneVente = ligneVenteService.save(ligneVenteDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(ligneVente);
    }

    @Operation(summary = "Récupérer une ligne de vente par ID", description = "Retourne une ligne de vente spécifique en fonction de son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ligne de vente récupérée avec succès"),
            @ApiResponse(responseCode = "404", description = "Ligne de vente introuvable")
    })
    @GetMapping("/{id}")
    public ResponseEntity<LigneVente> getLigneVenteById(@PathVariable Long id) {
        LigneVente ligneVente = ligneVenteService.getLigneVenteById(id);
        return ResponseEntity.ok(ligneVente);
    }

    @Operation(summary = "Récupérer toutes les lignes de vente", description = "Retourne la liste de toutes les lignes de vente en base de données.")
    @ApiResponse(responseCode = "200", description = "Liste des lignes de vente récupérée avec succès")
    @GetMapping
    public ResponseEntity<List<LigneVente>> getAllLigneVentes() {
        List<LigneVente> lignesVentes = ligneVenteService.getLigneVentes();
        return ResponseEntity.ok(lignesVentes);
    }

    @Operation(summary = "Mettre à jour une ligne de vente", description = "Modifie une ligne de vente existante en base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ligne de vente mise à jour avec succès"),
            @ApiResponse(responseCode = "404", description = "Ligne de vente introuvable"),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })
    @PutMapping("/{id}")
    public ResponseEntity<LigneVente> updateLigneVente(@PathVariable Long id, @Valid @RequestBody LigneVenteDto ligneVenteDto) {
        LigneVente updatedLigneVente = ligneVenteService.update(id, ligneVenteDto);
        return ResponseEntity.ok(updatedLigneVente);
    }

    @Operation(summary = "Supprimer une ligne de vente", description = "Supprime une ligne de vente en fonction de son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ligne de vente supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "Ligne de vente introuvable")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLigneVente(@PathVariable Long id) {
        return ligneVenteService.delete(id);
    }
}