package org.kfokam48.gestiondestockbackend.service;

import jakarta.validation.Valid;
import org.kfokam48.gestiondestockbackend.dto.LigneCommandeFournisseurDto;
import org.kfokam48.gestiondestockbackend.exception.RessourceNotFoundException;
import org.kfokam48.gestiondestockbackend.mapper.ArticleMapper;
import org.kfokam48.gestiondestockbackend.mapper.CommandeFournisseurMapper;
import org.kfokam48.gestiondestockbackend.mapper.LigneCommandeFournisseurMapper;
import org.kfokam48.gestiondestockbackend.model.LigneCommandeFournisseur;
import org.kfokam48.gestiondestockbackend.repository.LigneCommandeFournisseurRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LigneCommandeFournisseurServiceImpl implements LigneCommandeFournisseurService {
    private final LigneCommandeFournisseurRepository repository;
    private final LigneCommandeFournisseurMapper mapper;
    private final ArticleMapper articleMapper1;
    private final CommandeFournisseurMapper commandeMapper1;

    public LigneCommandeFournisseurServiceImpl(LigneCommandeFournisseurRepository repository, LigneCommandeFournisseurMapper mapper, ArticleMapper articleMapper1, CommandeFournisseurMapper commandeMapper1) {
        this.repository = repository;
        this.mapper = mapper;
        this.articleMapper1 = articleMapper1;
        this.commandeMapper1 = commandeMapper1;
    }

    @Override
    public LigneCommandeFournisseur findById(Long id) {
        return repository.findById(id).orElseThrow(()->new RessourceNotFoundException("La ligne de commande n'existe pas"));
    }

    @Override
    public List<LigneCommandeFournisseur> findAll() {

        return repository.findAll();
    }

    @Override
    public ResponseEntity<String> deleteById(Long id) {
        LigneCommandeFournisseur entity = repository.findById(id).orElseThrow(()->new RessourceNotFoundException("La ligne de commande n'existe pas"));
        repository.deleteById(id);
        return ResponseEntity.ok("ligne de commande deleted");
    }

    @Override
    public LigneCommandeFournisseur save(LigneCommandeFournisseurDto entity) {

        return repository.save(mapper.ligneCommandeFournisseurDtoToLigneCommandeFournisseur(entity));
    }

    @Override
    public LigneCommandeFournisseur update(Long id,@Valid LigneCommandeFournisseurDto entity) {

        LigneCommandeFournisseur ligneCommandeFournisseur = repository.findById(id).orElseThrow(()->new RessourceNotFoundException("La ligne de commande n'existe pas"));
        ligneCommandeFournisseur.setCommandeFournisseur(commandeMapper1.commandeFournisseurDtotoCommandeFournisseur(entity.getCommandeFournisseur()));
        ligneCommandeFournisseur.setArticle(articleMapper1.articleDtoToArticle(entity.getArticle()));
        ligneCommandeFournisseur.setPrixUnitaire(entity.getPrixUnitaire());
        ligneCommandeFournisseur.setQuantite(entity.getQuantite());
         repository.save(ligneCommandeFournisseur);
        return ligneCommandeFournisseur;
    }
}
