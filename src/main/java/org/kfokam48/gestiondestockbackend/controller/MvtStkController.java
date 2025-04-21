package org.kfokam48.gestiondestockbackend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.kfokam48.gestiondestockbackend.dto.MvtStkDto;
import org.kfokam48.gestiondestockbackend.model.MvtStk;
import org.kfokam48.gestiondestockbackend.service.MvtStkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mouvementsStock")
public class MvtStkController {

    private final MvtStkService mvtStkService;

    public MvtStkController(MvtStkService mvtStkService) {
        this.mvtStkService = mvtStkService;
    }

    @Operation(summary = "Créer un mouvement de stock", description = "Ajoute un nouveau mouvement de stock en base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Mouvement de stock créé avec succès"),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })
    @PostMapping
    public ResponseEntity<MvtStk> createMvtStk(@Valid @RequestBody MvtStkDto mvtStkDto) {
        MvtStk mvtStk = mvtStkService.createMvtStk(mvtStkDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(mvtStk);
    }

    @Operation(summary = "Récupérer un mouvement de stock par ID", description = "Retourne un mouvement de stock spécifique en fonction de son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Mouvement de stock récupéré avec succès"),
            @ApiResponse(responseCode = "404", description = "Mouvement de stock introuvable")
    })
    @GetMapping("/{id}")
    public ResponseEntity<MvtStk> getMvtStkById(@PathVariable Long id) {
        MvtStk mvtStk = mvtStkService.getMvtStkById(id);
        return ResponseEntity.ok(mvtStk);
    }

    @Operation(summary = "Récupérer tous les mouvements de stock", description = "Retourne la liste de tous les mouvements de stock en base de données.")
    @ApiResponse(responseCode = "200", description = "Liste des mouvements de stock récupérée avec succès")
    @GetMapping
    public ResponseEntity<List<MvtStk>> getAllMvtStks() {
        List<MvtStk> mouvements = mvtStkService.getMvtStkList();
        return ResponseEntity.ok(mouvements);
    }

    @Operation(summary = "Mettre à jour un mouvement de stock", description = "Modifie un mouvement de stock existant en base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Mouvement de stock mis à jour avec succès"),
            @ApiResponse(responseCode = "404", description = "Mouvement de stock introuvable"),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })
    @PutMapping("/{id}")
    public ResponseEntity<MvtStk> updateMvtStk(@PathVariable Long id, @Valid @RequestBody MvtStkDto mvtStkDto) {
        MvtStk updatedMvtStk = mvtStkService.updateMvtStk(id, mvtStkDto);
        return ResponseEntity.ok(updatedMvtStk);
    }

    @Operation(summary = "Supprimer un mouvement de stock", description = "Supprime un mouvement de stock en fonction de son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Mouvement de stock supprimé avec succès"),
            @ApiResponse(responseCode = "404", description = "Mouvement de stock introuvable")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMvtStk(@PathVariable Long id) {
        return mvtStkService.deleteMvtStkById(id);
    }
}