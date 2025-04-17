package org.kfokam48.gestiondestockbackend.controller;

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

    @PostMapping
    public ResponseEntity<Fournisseur> createFournisseur(@Valid @RequestBody FournisseurDto fournisseurDto) {
        Fournisseur fournisseur = fournisseurService.saveFournisseur(fournisseurDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(fournisseur);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fournisseur> getFournisseurById(@PathVariable Long id) {
        Fournisseur fournisseur = fournisseurService.getFournisseurById(id);
        return ResponseEntity.ok(fournisseur);
    }

    @GetMapping
    public ResponseEntity<List<Fournisseur>> getAllFournisseurs() {
        List<Fournisseur> fournisseurs = fournisseurService.getAllFournisseur();
        return ResponseEntity.ok(fournisseurs);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fournisseur> updateFournisseur(@PathVariable Long id, @Valid @RequestBody FournisseurDto fournisseurDto) {
        Fournisseur updatedFournisseur = fournisseurService.updateFournisseur(id, fournisseurDto);
        return ResponseEntity.ok(updatedFournisseur);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFournisseur(@PathVariable Long id) {
        return fournisseurService.deleteFournisseur(id);
    }
}
