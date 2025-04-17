package org.kfokam48.gestiondestockbackend.controller;

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

    @PostMapping
    public ResponseEntity<Entreprise> createEntreprise(@Valid @RequestBody EntrepriseDto entrepriseDto) {
        Entreprise entreprise = entrepriseService.addEntreprise(entrepriseDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(entreprise);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entreprise> getEntrepriseById(@PathVariable Long id) {
        Entreprise entreprise = entrepriseService.getEntrepriseById(id);
        return ResponseEntity.ok(entreprise);
    }

    @GetMapping
    public ResponseEntity<List<Entreprise>> getAllEntreprises() {
        List<Entreprise> entreprises = entrepriseService.getAllEntreprises();
        return ResponseEntity.ok(entreprises);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entreprise> updateEntreprise(@PathVariable Long id, @Valid @RequestBody EntrepriseDto entrepriseDto) {
        Entreprise updatedEntreprise = entrepriseService.updateEntreprise(id, entrepriseDto);
        return ResponseEntity.ok(updatedEntreprise);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEntreprise(@PathVariable Long id) {
        return entrepriseService.deleteEntreprise(id);
    }
}
