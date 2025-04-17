package org.kfokam48.gestiondestockbackend.controller;

import jakarta.validation.Valid;
import org.kfokam48.gestiondestockbackend.dto.UtilisateurDto;
import org.kfokam48.gestiondestockbackend.model.Utilisateur;
import org.kfokam48.gestiondestockbackend.service.UtilisateurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @PostMapping
    public ResponseEntity<Utilisateur> createUtilisateur(@Valid @RequestBody UtilisateurDto utilisateurDto) {
        Utilisateur utilisateur = utilisateurService.addUtilisateur(utilisateurDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(utilisateur);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Utilisateur> getUtilisateurById(@PathVariable Long id) {
        Utilisateur utilisateur = utilisateurService.getUtilisateurById(id);
        return ResponseEntity.ok(utilisateur);
    }

    @GetMapping
    public ResponseEntity<List<Utilisateur>> getAllUtilisateurs() {
        List<Utilisateur> utilisateurs = utilisateurService.getAllUtilisateurs();
        return ResponseEntity.ok(utilisateurs);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Utilisateur> updateUtilisateur(@PathVariable Long id, @Valid @RequestBody UtilisateurDto utilisateurDto) {
        Utilisateur updatedUtilisateur = utilisateurService.updateUtilisateur(id, utilisateurDto);
        return ResponseEntity.ok(updatedUtilisateur);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUtilisateur(@PathVariable Long id) {
        return utilisateurService.deleteUtilisateur(id);
    }
}
