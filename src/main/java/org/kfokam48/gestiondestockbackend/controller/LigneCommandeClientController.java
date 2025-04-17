package org.kfokam48.gestiondestockbackend.controller;

import jakarta.validation.Valid;
import org.kfokam48.gestiondestockbackend.dto.LigneCommandeClientDto;
import org.kfokam48.gestiondestockbackend.model.LigneCommandeClient;
import org.kfokam48.gestiondestockbackend.service.LigneCommandeClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ligneCommandeClients")
public class LigneCommandeClientController {

    private final LigneCommandeClientService ligneCommandeClientService;

    public LigneCommandeClientController(LigneCommandeClientService ligneCommandeClientService) {
        this.ligneCommandeClientService = ligneCommandeClientService;
    }

    @PostMapping
    public ResponseEntity<LigneCommandeClient> createLigneCommandeClient(@Valid @RequestBody LigneCommandeClientDto lc) {
        LigneCommandeClient ligneCommandeClient = ligneCommandeClientService.addLigneCommandeClient(lc);
        return ResponseEntity.status(HttpStatus.CREATED).body(ligneCommandeClient);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LigneCommandeClient> getLigneCommandeClientById(@PathVariable Long id) {
        LigneCommandeClient ligneCommandeClient = ligneCommandeClientService.getLigneCommandeClient(id);
        return ResponseEntity.ok(ligneCommandeClient);
    }

    @GetMapping
    public ResponseEntity<List<LigneCommandeClient>> getAllLigneCommandeClients() {
        List<LigneCommandeClient> lignes = ligneCommandeClientService.getAllLigneCommandeClient();
        return ResponseEntity.ok(lignes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LigneCommandeClient> updateLigneCommandeClient(@PathVariable Long id, @Valid @RequestBody LigneCommandeClientDto lc) {
        LigneCommandeClient updatedLigneCommandeClient = ligneCommandeClientService.updateLigneCommandeClient(id, lc);
        return ResponseEntity.ok(updatedLigneCommandeClient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLigneCommandeClient(@PathVariable Long id) {
        return ligneCommandeClientService.deleteLigneCommandeClient(id);
    }
}