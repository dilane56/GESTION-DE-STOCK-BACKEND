package org.kfokam48.gestiondestockbackend.service;

import org.kfokam48.gestiondestockbackend.dto.UtilisateurDto;
import org.kfokam48.gestiondestockbackend.model.Utilisateur;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UtilisateurService {
    Utilisateur getUtilisateurById(Long id);
    List<Utilisateur> getAllUtilisateurs();
    Utilisateur getUtilisateurByEmail(String email);
    Utilisateur addUtilisateur(UtilisateurDto utilisateurDto);
    Utilisateur updateUtilisateur(Long id, UtilisateurDto utilisateurDto);
    ResponseEntity<String> deleteUtilisateur(Long id);
}
