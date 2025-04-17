package org.kfokam48.gestiondestockbackend.controller;

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

    @PostMapping
    public ResponseEntity<CommandeFournisseur> createCommandeFournisseur(@Valid @RequestBody CommandeFournisseurDto commandeFournisseurDto) {
        CommandeFournisseur commandeFournisseur = commandeFournisseurService.addCommandeFournisseur(commandeFournisseurDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(commandeFournisseur);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommandeFournisseur> getCommandeFournisseurById(@PathVariable Long id) {
        CommandeFournisseur commandeFournisseur = commandeFournisseurService.getCommandeFournisseurById(id);
        return ResponseEntity.ok(commandeFournisseur);
    }

    @GetMapping
    public ResponseEntity<List<CommandeFournisseur>> getAllCommandeFournisseurs() {
        List<CommandeFournisseur> commandes = commandeFournisseurService.getAllCommandeFournisseur();
        return ResponseEntity.ok(commandes);
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<CommandeFournisseur> getCommandeByCode(@PathVariable String code) {
        CommandeFournisseur commandeFournisseur = commandeFournisseurService.getCommandeByCode(code);
        return ResponseEntity.ok(commandeFournisseur);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommandeFournisseur> updateCommandeFournisseur(@PathVariable Long id, @Valid @RequestBody CommandeFournisseurDto commandeFournisseurDto) {
        CommandeFournisseur updatedCommandeFournisseur = commandeFournisseurService.updateCommande(id, commandeFournisseurDto);
        return ResponseEntity.ok(updatedCommandeFournisseur);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCommandeFournisseur(@PathVariable Long id) {
        return commandeFournisseurService.deleteCommande(id);
    }
}