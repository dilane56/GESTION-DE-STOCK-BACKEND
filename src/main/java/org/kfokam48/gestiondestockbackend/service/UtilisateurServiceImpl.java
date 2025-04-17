package org.kfokam48.gestiondestockbackend.service;

import jakarta.validation.Valid;
import org.kfokam48.gestiondestockbackend.dto.UtilisateurDto;
import org.kfokam48.gestiondestockbackend.exception.RessourceNotFoundException;
import org.kfokam48.gestiondestockbackend.mapper.AdresseMapper;
import org.kfokam48.gestiondestockbackend.mapper.EntrepriseMapper;
import org.kfokam48.gestiondestockbackend.mapper.UtilisateurMapper;
import org.kfokam48.gestiondestockbackend.model.Utilisateur;
import org.kfokam48.gestiondestockbackend.repository.UtilisateurRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UtilisateurServiceImpl implements UtilisateurService {
    private final UtilisateurRepository utilisateurRepository;
    private final UtilisateurMapper utilisateurMapper;
    private final AdresseMapper adresseMapper;
    private final EntrepriseMapper entrepriseMapper;

    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository, UtilisateurMapper utilisateurMapper, AdresseMapper adresseMapper, EntrepriseMapper entrepriseMapper) {
        this.utilisateurRepository = utilisateurRepository;
        this.utilisateurMapper = utilisateurMapper;
        this.adresseMapper = adresseMapper;
        this.entrepriseMapper = entrepriseMapper;
    }

    @Override
    public Utilisateur getUtilisateurById(Long id) {
        return utilisateurRepository.findById(id).orElseThrow(()-> new RessourceNotFoundException("Utilisateur not found"));
    }

    @Override
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    @Override
    public Utilisateur getUtilisateurByEmail(String email) {
        return null;
    }

    @Override
    public Utilisateur addUtilisateur(@Valid UtilisateurDto utilisateurDto) {

        return utilisateurRepository.save(utilisateurMapper.utilisateurDtoToUtilisateur(utilisateurDto));
    }

    @Override
    public Utilisateur updateUtilisateur(Long id,@Valid UtilisateurDto utilisateurDto) {
        Utilisateur utilisateur = utilisateurRepository.findById(id).orElseThrow(()-> new RessourceNotFoundException("Utilisateur not found"));
        utilisateur.setNom(utilisateurDto.getNom());
        utilisateur.setPrenom(utilisateurDto.getPrenom());
        utilisateur.setEmail(utilisateurDto.getEmail());
        utilisateur.setPassword(utilisateurDto.getPassword());
        utilisateur.setDateNaissance(utilisateurDto.getDateNaissance());
        utilisateur.setPhoto(utilisateurDto.getPhoto());
        utilisateur.setAdresse(adresseMapper.adresseDtoToAdresse(utilisateurDto.getAdresse()));
        utilisateur.setEntreprise(entrepriseMapper.entrepriseDtoToEntreprise(utilisateurDto.getEntreprise()));
        utilisateur.setRoles(utilisateurMapper.rolesDtolistTorolesList(utilisateurDto.getRoles()));
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public ResponseEntity<String> deleteUtilisateur(Long id) {

        Utilisateur utilisateur = utilisateurRepository.findById(id).orElseThrow(()-> new RessourceNotFoundException("Utilisateur not found"));
        utilisateurRepository.deleteById(id);
        return ResponseEntity.ok("Utilisateur deleted");
    }
}
