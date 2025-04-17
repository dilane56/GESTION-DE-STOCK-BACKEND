package org.kfokam48.gestiondestockbackend.controller;

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

    @PostMapping
    public ResponseEntity<LigneCommandeFournisseur> createLigneCommandeFournisseur(@Valid @RequestBody LigneCommandeFournisseurDto entity) {
        LigneCommandeFournisseur ligneCommandeFournisseur = ligneCommandeFournisseurService.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(ligneCommandeFournisseur);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LigneCommandeFournisseur> getLigneCommandeFournisseurById(@PathVariable Long id) {
        LigneCommandeFournisseur ligneCommandeFournisseur = ligneCommandeFournisseurService.findById(id);
        return ResponseEntity.ok(ligneCommandeFournisseur);
    }

    @GetMapping
    public ResponseEntity<List<LigneCommandeFournisseur>> getAllLigneCommandeFournisseurs() {
        List<LigneCommandeFournisseur> lignes = ligneCommandeFournisseurService.findAll();
        return ResponseEntity.ok(lignes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LigneCommandeFournisseur> updateLigneCommandeFournisseur(@PathVariable Long id, @Valid @RequestBody LigneCommandeFournisseurDto entity) {
        LigneCommandeFournisseur updatedLigneCommandeFournisseur = ligneCommandeFournisseurService.update(id, entity);
        return ResponseEntity.ok(updatedLigneCommandeFournisseur);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLigneCommandeFournisseur(@PathVariable Long id) {
        return ligneCommandeFournisseurService.deleteById(id);
    }
}