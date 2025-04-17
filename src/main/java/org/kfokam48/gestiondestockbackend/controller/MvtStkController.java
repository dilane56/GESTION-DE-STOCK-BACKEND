package org.kfokam48.gestiondestockbackend.controller;

import jakarta.validation.Valid;
import org.kfokam48.gestiondestockbackend.dto.MvtStkDto;
import org.kfokam48.gestiondestockbackend.model.MvtStk;
import org.kfokam48.gestiondestockbackend.service.MvtStkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mouvementsStock")
public class MvtStkController {

    private final MvtStkService mvtStkService;

    public MvtStkController(MvtStkService mvtStkService) {
        this.mvtStkService = mvtStkService;
    }

    @PostMapping
    public ResponseEntity<MvtStk> createMvtStk(@Valid @RequestBody MvtStkDto mvtStkDto) {
        MvtStk mvtStk = mvtStkService.createMvtStk(mvtStkDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(mvtStk);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MvtStk> getMvtStkById(@PathVariable Long id) {
        MvtStk mvtStk = mvtStkService.getMvtStkById(id);
        return ResponseEntity.ok(mvtStk);
    }

    @GetMapping
    public ResponseEntity<List<MvtStk>> getAllMvtStks() {
        List<MvtStk> mouvements = mvtStkService.getMvtStkList();
        return ResponseEntity.ok(mouvements);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MvtStk> updateMvtStk(@PathVariable Long id, @Valid @RequestBody MvtStkDto mvtStkDto) {
        MvtStk updatedMvtStk = mvtStkService.updateMvtStk(id, mvtStkDto);
        return ResponseEntity.ok(updatedMvtStk);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMvtStk(@PathVariable Long id) {
        return mvtStkService.deleteMvtStkById(id);
    }
}