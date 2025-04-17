package org.kfokam48.gestiondestockbackend.controller;

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

    @PostMapping
    public ResponseEntity<Roles> createRole(@Valid @RequestBody RoleDto roleDto) {
        Roles role = rolesService.addRole(roleDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(role);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Roles> getRoleById(@PathVariable Long id) {
        Roles role = rolesService.getRolesById(id);
        return ResponseEntity.ok(role);
    }

    @GetMapping
    public ResponseEntity<List<Roles>> getAllRoles() {
        List<Roles> rolesList = rolesService.getAllRoles();
        return ResponseEntity.ok(rolesList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Roles> updateRole(@PathVariable Long id, @Valid @RequestBody RoleDto roleDto) {
        Roles updatedRole = rolesService.updateRole(id, roleDto);
        return ResponseEntity.ok(updatedRole);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRole(@PathVariable Long id) {
        return rolesService.deleteRole(id);
    }
}