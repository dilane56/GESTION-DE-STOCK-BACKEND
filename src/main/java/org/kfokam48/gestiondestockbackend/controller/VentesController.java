package org.kfokam48.gestiondestockbackend.controller;

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

    @PostMapping
    public ResponseEntity<Ventes> createVente(@Valid @RequestBody VentesDto ventesDto) {
        Ventes vente = ventesService.saveVente(ventesDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(vente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ventes> getVenteById(@PathVariable Long id) {
        Ventes vente = ventesService.findVenteById(id);
        return ResponseEntity.ok(vente);
    }

    @GetMapping
    public ResponseEntity<List<Ventes>> getAllVentes() {
        List<Ventes> ventes = ventesService.findAllVentes();
        return ResponseEntity.ok(ventes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ventes> updateVente(@PathVariable Long id, @Valid @RequestBody VentesDto ventesDto) {
        Ventes updatedVente = ventesService.updateVente(id, ventesDto);
        return ResponseEntity.ok(updatedVente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVente(@PathVariable Long id) {
        return ventesService.deleteVente(id);
    }
}
