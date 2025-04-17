package org.kfokam48.gestiondestockbackend.controller;

import jakarta.validation.Valid;
import org.kfokam48.gestiondestockbackend.dto.LigneVenteDto;
import org.kfokam48.gestiondestockbackend.model.LigneVente;
import org.kfokam48.gestiondestockbackend.service.LigneVenteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ligneVentes")
public class LigneVenteController {

    private final LigneVenteService ligneVenteService;

    public LigneVenteController(LigneVenteService ligneVenteService) {
        this.ligneVenteService = ligneVenteService;
    }

    @PostMapping
    public ResponseEntity<LigneVente> createLigneVente(@Valid @RequestBody LigneVenteDto ligneVenteDto) {
        LigneVente ligneVente = ligneVenteService.save(ligneVenteDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(ligneVente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LigneVente> getLigneVenteById(@PathVariable Long id) {
        LigneVente ligneVente = ligneVenteService.getLigneVenteById(id);
        return ResponseEntity.ok(ligneVente);
    }

    @GetMapping
    public ResponseEntity<List<LigneVente>> getAllLigneVentes() {
        List<LigneVente> lignesVentes = ligneVenteService.getLigneVentes();
        return ResponseEntity.ok(lignesVentes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LigneVente> updateLigneVente(@PathVariable Long id, @Valid @RequestBody LigneVenteDto ligneVenteDto) {
        LigneVente updatedLigneVente = ligneVenteService.update(id, ligneVenteDto);
        return ResponseEntity.ok(updatedLigneVente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLigneVente(@PathVariable Long id) {
        return ligneVenteService.delete(id);
    }
}