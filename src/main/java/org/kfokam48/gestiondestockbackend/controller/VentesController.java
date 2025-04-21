package org.kfokam48.gestiondestockbackend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.kfokam48.gestiondestockbackend.dto.VentesDto;
import org.kfokam48.gestiondestockbackend.model.Ventes;
import org.kfokam48.gestiondestockbackend.service.VentesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventes")
public class VentesController {

    private final VentesService ventesService;

    public VentesController(VentesService ventesService) {
        this.ventesService = ventesService;
    }

    @Operation(summary = "Créer une vente", description = "Ajoute une nouvelle vente en base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Vente créée avec succès"),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })
    @PostMapping
    public ResponseEntity<Ventes> createVente(@Valid @RequestBody VentesDto ventesDto) {
        Ventes vente = ventesService.saveVente(ventesDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(vente);
    }

    @Operation(summary = "Récupérer une vente par ID", description = "Retourne une vente spécifique en fonction de son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Vente récupérée avec succès"),
            @ApiResponse(responseCode = "404", description = "Vente introuvable")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Ventes> getVenteById(@PathVariable Long id) {
        Ventes vente = ventesService.findVenteById(id);
        return ResponseEntity.ok(vente);
    }

    @Operation(summary = "Récupérer toutes les ventes", description = "Retourne la liste de toutes les ventes en base de données.")
    @ApiResponse(responseCode = "200", description = "Liste des ventes récupérée avec succès")
    @GetMapping
    public ResponseEntity<List<Ventes>> getAllVentes() {
        List<Ventes> ventes = ventesService.findAllVentes();
        return ResponseEntity.ok(ventes);
    }

    @Operation(summary = "Mettre à jour une vente", description = "Modifie une vente existante en base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Vente mise à jour avec succès"),
            @ApiResponse(responseCode = "404", description = "Vente introuvable"),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Ventes> updateVente(@PathVariable Long id, @Valid @RequestBody VentesDto ventesDto) {
        Ventes updatedVente = ventesService.updateVente(id, ventesDto);
        return ResponseEntity.ok(updatedVente);
    }

    @Operation(summary = "Supprimer une vente", description = "Supprime une vente en fonction de son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Vente supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "Vente introuvable")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVente(@PathVariable Long id) {
        return ventesService.deleteVente(id);
    }
}