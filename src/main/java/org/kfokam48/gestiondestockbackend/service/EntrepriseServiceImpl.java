package org.kfokam48.gestiondestockbackend.service;

import jakarta.validation.Valid;
import org.kfokam48.gestiondestockbackend.dto.EntrepriseDto;
import org.kfokam48.gestiondestockbackend.exception.RessourceNotFoundException;
import org.kfokam48.gestiondestockbackend.mapper.AdresseMapper;
import org.kfokam48.gestiondestockbackend.mapper.EntrepriseMapper;
import org.kfokam48.gestiondestockbackend.model.Entreprise;
import org.kfokam48.gestiondestockbackend.repository.EntrepriseRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EntrepriseServiceImpl implements EntrepriseService {
    private final EntrepriseRepository entrepriseRepository;
    private final EntrepriseMapper entrepriseMapper;
    private final AdresseMapper adresseMapper;

    public EntrepriseServiceImpl(EntrepriseRepository entrepriseRepository, EntrepriseMapper entrepriseMapper, AdresseMapper adresseMapper) {
        this.entrepriseRepository = entrepriseRepository;
        this.entrepriseMapper = entrepriseMapper;
        this.adresseMapper = adresseMapper;
    }

    @Override
    public Entreprise getEntrepriseById(Long id) {
        return entrepriseRepository.findById(id).orElseThrow(()->new RessourceNotFoundException("L'entreprise avec l'ID: "+id+" n'existe pas"));
    }

    @Override
    public List<Entreprise> getAllEntreprises() {
        return List.of();
    }

    @Override
    public Entreprise addEntreprise(@Valid EntrepriseDto ent) {
        return entrepriseRepository.save(entrepriseMapper.entrepriseDtoToEntreprise(ent));
    }

    @Override
    public Entreprise updateEntreprise(Long id,@Valid EntrepriseDto entrepriseDto) {
        Entreprise entreprise = entrepriseRepository.findById(id).orElseThrow(()->new RessourceNotFoundException("L'entreprise avec l'ID: "+id+" n'existe pas"));
        entreprise.setAdresse(adresseMapper.adresseDtoToAdresse(entrepriseDto.getAdresse()));
        entreprise.setNom(entrepriseDto.getNom());
        entreprise.setDescription(entrepriseDto.getDescription());
        entreprise.setCodeFiscal(entrepriseDto.getCodeFiscal());
        entreprise.setMail(entrepriseDto.getMail());
        entreprise.setTelephone(entrepriseDto.getTelephone());
        entreprise.setSiteWeb(entrepriseDto.getSiteWeb());
        entreprise.setUtilisateurs(entrepriseMapper.utilisateursDtoListToUtilisateursList(entrepriseDto.getUtilisateurs()));
        entrepriseRepository.save(entreprise);
        return entreprise;
    }

    @Override
    public ResponseEntity<String> deleteEntreprise(Long id) {
        Entreprise entreprise = entrepriseRepository.findById(id).orElseThrow(()->new RessourceNotFoundException("L'entreprise avec l'ID: "+id+" n'existe pas"));
        entrepriseRepository.delete(entreprise);
        return ResponseEntity.ok("L'entreprise a été supprimé avec succès!");
    }
}
