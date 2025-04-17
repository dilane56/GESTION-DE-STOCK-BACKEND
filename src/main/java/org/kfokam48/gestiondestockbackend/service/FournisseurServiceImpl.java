package org.kfokam48.gestiondestockbackend.service;

import jakarta.validation.Valid;
import org.kfokam48.gestiondestockbackend.dto.FournisseurDto;
import org.kfokam48.gestiondestockbackend.exception.RessourceNotFoundException;
import org.kfokam48.gestiondestockbackend.mapper.AdresseMapper;
import org.kfokam48.gestiondestockbackend.mapper.FournisseurMapper;
import org.kfokam48.gestiondestockbackend.model.Fournisseur;
import org.kfokam48.gestiondestockbackend.repository.FournisseurRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FournisseurServiceImpl implements FournisseurService {
    private final FournisseurRepository fournisseurRepository;
    private final FournisseurMapper fournisseurMapper;
    private AdresseMapper adresseMapper;

    public FournisseurServiceImpl(FournisseurRepository fournisseurRepository, FournisseurMapper fournisseurMapper, AdresseMapper adresseMapper) {
        this.fournisseurRepository = fournisseurRepository;
        this.fournisseurMapper = fournisseurMapper;
        this.adresseMapper = adresseMapper;
    }

    @Override
    public Fournisseur getFournisseurById(Long id) {
        return fournisseurRepository.findById(id).orElseThrow(()->new RessourceNotFoundException("Aucun fournisseur trouvé avec cet ID: "+id));
    }

    @Override
    public List<Fournisseur> getAllFournisseur() {
        return fournisseurRepository.findAll();
    }

    @Override
    public Fournisseur saveFournisseur(@Valid FournisseurDto fournisseurDto) {
        return fournisseurRepository.save(fournisseurMapper.fournisseurDtotoFournisseur(fournisseurDto));
    }

    @Override
    public ResponseEntity<String> deleteFournisseur(Long id) {
        Fournisseur fournisseur = fournisseurRepository.findById(id).orElseThrow(()->new RessourceNotFoundException("Aucun fournisseur trouvé avec cet ID: "+id));
       fournisseurRepository.deleteById(id);
        return ResponseEntity.ok("Fournisseur supprimer avec succès");
    }

    @Override
    public Fournisseur updateFournisseur(Long id,@Valid FournisseurDto fournisseurDto) {
        Fournisseur fournisseur = fournisseurRepository.findById(id).orElseThrow(()->new RessourceNotFoundException("Aucun fournisseur trouvé avec cet ID: "+id));
        fournisseur.setNom(fournisseurDto.getNom());
        fournisseur.setPrenom(fournisseurDto.getPrenom());
        fournisseur.setMail(fournisseurDto.getMail());
        fournisseur.setNumTel(fournisseurDto.getNumTel());
        fournisseur.setPhoto(fournisseurDto.getPhoto());
        fournisseur.setAdresse(adresseMapper.adresseDtoToAdresse(fournisseurDto.getAdresse()));
        fournisseur.setCommandeFournisseurs(fournisseurMapper.commandeFournisseurListDtoToCommandeFournisseurList(fournisseurDto.getCommandeFournisseurs()));
        fournisseurRepository.save(fournisseur);
        return fournisseur;
    }
}
