package org.kfokam48.gestiondestockbackend.service;

import jakarta.validation.Valid;
import org.kfokam48.gestiondestockbackend.dto.LigneCommandeClientDto;
import org.kfokam48.gestiondestockbackend.exception.RessourceNotFoundException;
import org.kfokam48.gestiondestockbackend.mapper.ArticleMapper;
import org.kfokam48.gestiondestockbackend.mapper.CommandeClientMapper;
import org.kfokam48.gestiondestockbackend.mapper.LigneCommandeClientMapper;
import org.kfokam48.gestiondestockbackend.model.LigneCommandeClient;
import org.kfokam48.gestiondestockbackend.repository.LigneCommandeClientRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LigneCommandeClientServiceImpl implements LigneCommandeClientService {
    private final LigneCommandeClientRepository ligneCommandeClientRepository;
    private final LigneCommandeClientMapper ligneCommandeClientMapper;

    private final ArticleMapper articleMapper;
    private final CommandeClientMapper commandeClientMapper;

    public LigneCommandeClientServiceImpl(LigneCommandeClientRepository ligneCommandeClientRepository, LigneCommandeClientMapper ligneCommandeClientMapper, ArticleMapper articleMapper, CommandeClientMapper commandeClientMapper) {
        this.ligneCommandeClientRepository = ligneCommandeClientRepository;
        this.ligneCommandeClientMapper = ligneCommandeClientMapper;
        this.articleMapper = articleMapper;
        this.commandeClientMapper = commandeClientMapper;
    }

    @Override
    public LigneCommandeClient getLigneCommandeClient(Long id) {
        return ligneCommandeClientRepository.findById(id).orElseThrow(()->new RessourceNotFoundException("La ligne de commande n'existe pas"));
    }

    @Override
    public List<LigneCommandeClient> getAllLigneCommandeClient() {
        return ligneCommandeClientRepository.findAll();
    }

    @Override
    public LigneCommandeClient addLigneCommandeClient(@Valid LigneCommandeClientDto lc) {
        return ligneCommandeClientRepository.save(ligneCommandeClientMapper.ligneCommandeClientDtoToLigneCommandeClientDto(lc));
    }

    @Override
    public ResponseEntity<String> deleteLigneCommandeClient(Long id) {
        LigneCommandeClient client = ligneCommandeClientRepository.findById(id).orElseThrow(()->new RessourceNotFoundException("La ligne de commande n'existe pas"));
        ligneCommandeClientRepository.delete(client);
        return ResponseEntity.ok("La ligne de commande a été supprimée avec succès");
    }

    @Override
    public LigneCommandeClient updateLigneCommandeClient(Long id, @Valid LigneCommandeClientDto lc) {
        LigneCommandeClient ligneCommandeClient = ligneCommandeClientRepository.findById(id).orElseThrow(()->new RessourceNotFoundException("La ligne de commande n'existe pas"));
        ligneCommandeClient.setArticle(articleMapper.articleDtoToArticle(lc.getArticle()));
        ligneCommandeClient.setCommandeClient(commandeClientMapper.commandeClientDtoToCommandeClient(lc.getCommandeClient()));
        ligneCommandeClient.setPrixUnitaire(lc.getPrixUnitaire());
        ligneCommandeClient.setQuantite(lc.getQuantite());
        ligneCommandeClientRepository.save(ligneCommandeClient);
        return ligneCommandeClient;
    }
}
