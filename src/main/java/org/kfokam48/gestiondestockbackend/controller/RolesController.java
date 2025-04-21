package org.kfokam48.gestiondestockbackend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.kfokam48.gestiondestockbackend.dto.RoleDto;
import org.kfokam48.gestiondestockbackend.model.Roles;
import org.kfokam48.gestiondestockbackend.service.RolesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolesController {

    private final RolesService rolesService;

    public RolesController(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    @Operation(summary = "Créer un rôle", description = "Ajoute un nouveau rôle en base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Rôle créé avec succès"),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })
    @PostMapping
    public ResponseEntity<Roles> createRole(@Valid @RequestBody RoleDto roleDto) {
        Roles role = rolesService.addRole(roleDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(role);
    }

    @Operation(summary = "Récupérer un rôle par ID", description = "Retourne un rôle spécifique en fonction de son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Rôle récupéré avec succès"),
            @ApiResponse(responseCode = "404", description = "Rôle introuvable")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Roles> getRoleById(@PathVariable Long id) {
        Roles role = rolesService.getRolesById(id);
        return ResponseEntity.ok(role);
    }

    @Operation(summary = "Récupérer tous les rôles", description = "Retourne la liste de tous les rôles en base de données.")
    @ApiResponse(responseCode = "200", description = "Liste des rôles récupérée avec succès")
    @GetMapping
    public ResponseEntity<List<Roles>> getAllRoles() {
        List<Roles> rolesList = rolesService.getAllRoles();
        return ResponseEntity.ok(rolesList);
    }

    @Operation(summary = "Mettre à jour un rôle", description = "Modifie un rôle existant en base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Rôle mis à jour avec succès"),
            @ApiResponse(responseCode = "404", description = "Rôle introuvable"),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Roles> updateRole(@PathVariable Long id, @Valid @RequestBody RoleDto roleDto) {
        Roles updatedRole = rolesService.updateRole(id, roleDto);
        return ResponseEntity.ok(updatedRole);
    }

    @Operation(summary = "Supprimer un rôle", description = "Supprime un rôle en fonction de son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Rôle supprimé avec succès"),
            @ApiResponse(responseCode = "404", description = "Rôle introuvable")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRole(@PathVariable Long id) {
        return rolesService.deleteRole(id);
    }
}