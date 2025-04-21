package org.kfokam48.gestiondestockbackend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.kfokam48.gestiondestockbackend.dto.EntrepriseDto;
import org.kfokam48.gestiondestockbackend.model.Entreprise;
import org.kfokam48.gestiondestockbackend.service.EntrepriseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entreprises")
public class EntrepriseController {

    private final EntrepriseService entrepriseService;

    public EntrepriseController(EntrepriseService entrepriseService) {
        this.entrepriseService = entrepriseService;
    }

    @Operation(summary = "Créer une entreprise", description = "Ajoute une nouvelle entreprise en base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Entreprise créée avec succès"),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })
    @PostMapping
    public ResponseEntity<Entreprise> createEntreprise(@Valid @RequestBody EntrepriseDto entrepriseDto) {
        Entreprise entreprise = entrepriseService.addEntreprise(entrepriseDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(entreprise);
    }

    @Operation(summary = "Récupérer une entreprise par ID", description = "Retourne une entreprise spécifique en fonction de son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Entreprise récupérée avec succès"),
            @ApiResponse(responseCode = "404", description = "Entreprise introuvable")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Entreprise> getEntrepriseById(@PathVariable Long id) {
        Entreprise entreprise = entrepriseService.getEntrepriseById(id);
        return ResponseEntity.ok(entreprise);
    }

    @Operation(summary = "Récupérer toutes les entreprises", description = "Retourne la liste de toutes les entreprises en base de données.")
    @ApiResponse(responseCode = "200", description = "Liste des entreprises récupérée avec succès")
    @GetMapping
    public ResponseEntity<List<Entreprise>> getAllEntreprises() {
        List<Entreprise> entreprises = entrepriseService.getAllEntreprises();
        return ResponseEntity.ok(entreprises);
    }

    @Operation(summary = "Mettre à jour une entreprise", description = "Modifie une entreprise existante en base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Entreprise mise à jour avec succès"),
            @ApiResponse(responseCode = "404", description = "Entreprise introuvable"),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Entreprise> updateEntreprise(@PathVariable Long id, @Valid @RequestBody EntrepriseDto entrepriseDto) {
        Entreprise updatedEntreprise = entrepriseService.updateEntreprise(id, entrepriseDto);
        return ResponseEntity.ok(updatedEntreprise);
    }

    @Operation(summary = "Supprimer une entreprise", description = "Supprime une entreprise en fonction de son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Entreprise supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "Entreprise introuvable")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEntreprise(@PathVariable Long id) {
        return entrepriseService.deleteEntreprise(id);
    }
}