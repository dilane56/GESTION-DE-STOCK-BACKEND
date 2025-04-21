package org.kfokam48.gestiondestockbackend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.kfokam48.gestiondestockbackend.dto.LigneCommandeFournisseurDto;
import org.kfokam48.gestiondestockbackend.model.LigneCommandeFournisseur;
import org.kfokam48.gestiondestockbackend.service.LigneCommandeFournisseurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ligneCommandeFournisseurs")
public class LigneCommandeFournisseurController {

    private final LigneCommandeFournisseurService ligneCommandeFournisseurService;

    public LigneCommandeFournisseurController(LigneCommandeFournisseurService ligneCommandeFournisseurService) {
        this.ligneCommandeFournisseurService = ligneCommandeFournisseurService;
    }

    @Operation(summary = "Créer une ligne de commande fournisseur", description = "Ajoute une nouvelle ligne de commande fournisseur en base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ligne de commande fournisseur créée avec succès"),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })
    @PostMapping
    public ResponseEntity<LigneCommandeFournisseur> createLigneCommandeFournisseur(@Valid @RequestBody LigneCommandeFournisseurDto entity) {
        LigneCommandeFournisseur ligneCommandeFournisseur = ligneCommandeFournisseurService.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(ligneCommandeFournisseur);
    }

    @Operation(summary = "Récupérer une ligne de commande fournisseur par ID", description = "Retourne une ligne de commande fournisseur spécifique en fonction de son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ligne de commande fournisseur récupérée avec succès"),
            @ApiResponse(responseCode = "404", description = "Ligne de commande fournisseur introuvable")
    })
    @GetMapping("/{id}")
    public ResponseEntity<LigneCommandeFournisseur> getLigneCommandeFournisseurById(@PathVariable Long id) {
        LigneCommandeFournisseur ligneCommandeFournisseur = ligneCommandeFournisseurService.findById(id);
        return ResponseEntity.ok(ligneCommandeFournisseur);
    }

    @Operation(summary = "Récupérer toutes les lignes de commande fournisseur", description = "Retourne la liste de toutes les lignes de commande fournisseur en base de données.")
    @ApiResponse(responseCode = "200", description = "Liste des lignes de commande fournisseur récupérée avec succès")
    @GetMapping
    public ResponseEntity<List<LigneCommandeFournisseur>> getAllLigneCommandeFournisseurs() {
        List<LigneCommandeFournisseur> lignes = ligneCommandeFournisseurService.findAll();
        return ResponseEntity.ok(lignes);
    }

    @Operation(summary = "Mettre à jour une ligne de commande fournisseur", description = "Modifie une ligne de commande fournisseur existante en base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ligne de commande fournisseur mise à jour avec succès"),
            @ApiResponse(responseCode = "404", description = "Ligne de commande fournisseur introuvable"),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })
    @PutMapping("/{id}")
    public ResponseEntity<LigneCommandeFournisseur> updateLigneCommandeFournisseur(@PathVariable Long id, @Valid @RequestBody LigneCommandeFournisseurDto entity) {
        LigneCommandeFournisseur updatedLigneCommandeFournisseur = ligneCommandeFournisseurService.update(id, entity);
        return ResponseEntity.ok(updatedLigneCommandeFournisseur);
    }

    @Operation(summary = "Supprimer une ligne de commande fournisseur", description = "Supprime une ligne de commande fournisseur en fonction de son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ligne de commande fournisseur supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "Ligne de commande fournisseur introuvable")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLigneCommandeFournisseur(@PathVariable Long id) {
        return ligneCommandeFournisseurService.deleteById(id);
    }
}