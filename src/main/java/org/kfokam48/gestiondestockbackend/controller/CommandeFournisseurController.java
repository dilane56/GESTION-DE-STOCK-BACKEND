package org.kfokam48.gestiondestockbackend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.kfokam48.gestiondestockbackend.dto.CommandeFournisseurDto;
import org.kfokam48.gestiondestockbackend.model.CommandeFournisseur;
import org.kfokam48.gestiondestockbackend.service.CommandeFournisseurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commandeFournisseurs")
public class CommandeFournisseurController {

    private final CommandeFournisseurService commandeFournisseurService;

    public CommandeFournisseurController(CommandeFournisseurService commandeFournisseurService) {
        this.commandeFournisseurService = commandeFournisseurService;
    }

    @Operation(summary = "Créer une commande fournisseur", description = "Ajoute une nouvelle commande fournisseur en base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Commande fournisseur créée avec succès"),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })
    @PostMapping
    public ResponseEntity<CommandeFournisseur> createCommandeFournisseur(@Valid @RequestBody CommandeFournisseurDto commandeFournisseurDto) {
        CommandeFournisseur commandeFournisseur = commandeFournisseurService.addCommandeFournisseur(commandeFournisseurDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(commandeFournisseur);
    }

    @Operation(summary = "Récupérer une commande fournisseur par ID", description = "Retourne une commande fournisseur spécifique en fonction de son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Commande fournisseur récupérée avec succès"),
            @ApiResponse(responseCode = "404", description = "Commande fournisseur introuvable")
    })
    @GetMapping("/{id}")
    public ResponseEntity<CommandeFournisseur> getCommandeFournisseurById(@PathVariable Long id) {
        CommandeFournisseur commandeFournisseur = commandeFournisseurService.getCommandeFournisseurById(id);
        return ResponseEntity.ok(commandeFournisseur);
    }

    @Operation(summary = "Récupérer toutes les commandes fournisseurs", description = "Retourne la liste de toutes les commandes fournisseurs en base de données.")
    @ApiResponse(responseCode = "200", description = "Liste des commandes fournisseurs récupérée avec succès")
    @GetMapping
    public ResponseEntity<List<CommandeFournisseur>> getAllCommandeFournisseurs() {
        List<CommandeFournisseur> commandes = commandeFournisseurService.getAllCommandeFournisseur();
        return ResponseEntity.ok(commandes);
    }

    @Operation(summary = "Récupérer une commande fournisseur par code", description = "Retourne une commande fournisseur en fonction de son code unique.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Commande fournisseur récupérée avec succès"),
            @ApiResponse(responseCode = "404", description = "Commande fournisseur introuvable")
    })
    @GetMapping("/code/{code}")
    public ResponseEntity<CommandeFournisseur> getCommandeByCode(@PathVariable String code) {
        CommandeFournisseur commandeFournisseur = commandeFournisseurService.getCommandeByCode(code);
        return ResponseEntity.ok(commandeFournisseur);
    }

    @Operation(summary = "Mettre à jour une commande fournisseur", description = "Modifie une commande fournisseur existante en base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Commande fournisseur mise à jour avec succès"),
            @ApiResponse(responseCode = "404", description = "Commande fournisseur introuvable"),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })
    @PutMapping("/{id}")
    public ResponseEntity<CommandeFournisseur> updateCommandeFournisseur(@PathVariable Long id, @Valid @RequestBody CommandeFournisseurDto commandeFournisseurDto) {
        CommandeFournisseur updatedCommandeFournisseur = commandeFournisseurService.updateCommande(id, commandeFournisseurDto);
        return ResponseEntity.ok(updatedCommandeFournisseur);
    }

    @Operation(summary = "Supprimer une commande fournisseur", description = "Supprime une commande fournisseur en fonction de son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Commande fournisseur supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "Commande fournisseur introuvable")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCommandeFournisseur(@PathVariable Long id) {
        return commandeFournisseurService.deleteCommande(id);
    }
}