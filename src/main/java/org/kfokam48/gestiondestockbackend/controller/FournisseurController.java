package org.kfokam48.gestiondestockbackend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.kfokam48.gestiondestockbackend.dto.FournisseurDto;
import org.kfokam48.gestiondestockbackend.model.Fournisseur;
import org.kfokam48.gestiondestockbackend.service.FournisseurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fournisseurs")
public class FournisseurController {

    private final FournisseurService fournisseurService;

    public FournisseurController(FournisseurService fournisseurService) {
        this.fournisseurService = fournisseurService;
    }

    @Operation(summary = "Créer un fournisseur", description = "Ajoute un nouveau fournisseur en base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Fournisseur créé avec succès"),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })
    @PostMapping
    public ResponseEntity<Fournisseur> createFournisseur(@Valid @RequestBody FournisseurDto fournisseurDto) {
        Fournisseur fournisseur = fournisseurService.saveFournisseur(fournisseurDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(fournisseur);
    }

    @Operation(summary = "Récupérer un fournisseur par ID", description = "Retourne un fournisseur spécifique en fonction de son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fournisseur récupéré avec succès"),
            @ApiResponse(responseCode = "404", description = "Fournisseur introuvable")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Fournisseur> getFournisseurById(@PathVariable Long id) {
        Fournisseur fournisseur = fournisseurService.getFournisseurById(id);
        return ResponseEntity.ok(fournisseur);
    }

    @Operation(summary = "Récupérer tous les fournisseurs", description = "Retourne la liste de tous les fournisseurs en base de données.")
    @ApiResponse(responseCode = "200", description = "Liste des fournisseurs récupérée avec succès")
    @GetMapping
    public ResponseEntity<List<Fournisseur>> getAllFournisseurs() {
        List<Fournisseur> fournisseurs = fournisseurService.getAllFournisseur();
        return ResponseEntity.ok(fournisseurs);
    }

    @Operation(summary = "Mettre à jour un fournisseur", description = "Modifie un fournisseur existant en base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fournisseur mis à jour avec succès"),
            @ApiResponse(responseCode = "404", description = "Fournisseur introuvable"),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Fournisseur> updateFournisseur(@PathVariable Long id, @Valid @RequestBody FournisseurDto fournisseurDto) {
        Fournisseur updatedFournisseur = fournisseurService.updateFournisseur(id, fournisseurDto);
        return ResponseEntity.ok(updatedFournisseur);
    }

    @Operation(summary = "Supprimer un fournisseur", description = "Supprime un fournisseur en fonction de son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fournisseur supprimé avec succès"),
            @ApiResponse(responseCode = "404", description = "Fournisseur introuvable")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFournisseur(@PathVariable Long id) {
        return fournisseurService.deleteFournisseur(id);
    }
}