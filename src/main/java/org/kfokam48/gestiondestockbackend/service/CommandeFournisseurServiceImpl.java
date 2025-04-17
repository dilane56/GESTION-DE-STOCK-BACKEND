package org.kfokam48.gestiondestockbackend.service;

import jakarta.validation.Valid;
import org.kfokam48.gestiondestockbackend.dto.CommandeFournisseurDto;
import org.kfokam48.gestiondestockbackend.exception.RessourceNotFoundException;
import org.kfokam48.gestiondestockbackend.mapper.CommandeFournisseurMapper;
import org.kfokam48.gestiondestockbackend.mapper.FournisseurMapper;
import org.kfokam48.gestiondestockbackend.model.CommandeFournisseur;
import org.kfokam48.gestiondestockbackend.repository.CommandeFournisseurRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommandeFournisseurServiceImpl implements CommandeFournisseurService {
    private final CommandeFournisseurRepository commandeFournisseurRepository;
    private final CommandeFournisseurMapper commandeFournisseurMapper;
    private final FournisseurMapper fournisseurMapper;

    public CommandeFournisseurServiceImpl(CommandeFournisseurRepository commandeFournisseurRepository, CommandeFournisseurMapper commandeFournisseurMapper, FournisseurMapper fournisseurMapper) {
        this.commandeFournisseurRepository = commandeFournisseurRepository;
        this.commandeFournisseurMapper = commandeFournisseurMapper;
        this.fournisseurMapper = fournisseurMapper;
    }

    @Override
    public CommandeFournisseur getCommandeFournisseurById(Long id) {
        return commandeFournisseurRepository.findById(id).orElseThrow(()-> new RessourceNotFoundException(" La Ligne de commande fournisseur avec l'id : "+id+" n'existe pas"));
    }

    @Override
    public CommandeFournisseur addCommandeFournisseur(@Valid CommandeFournisseurDto commandeFournisseurDto) {
        return commandeFournisseurRepository.save(commandeFournisseurMapper.commandeFournisseurDtotoCommandeFournisseur(commandeFournisseurDto));
    }

    @Override
    public CommandeFournisseur updateCommande(Long id, @Valid CommandeFournisseurDto dto) {
        CommandeFournisseur commandeFournisseur = commandeFournisseurRepository.findById(id).orElseThrow(()-> new RessourceNotFoundException(" La Ligne de commande fournisseur avec l'id : "+id+" n'existe pas"));
        commandeFournisseur.setCode(dto.getCode());
        commandeFournisseur.setDateComande(dto.getDateComande());
        commandeFournisseur.setFournisseur(fournisseurMapper.fournisseurDtotoFournisseur(dto.getFournisseur()));
        return null;
    }

    @Override
    public ResponseEntity<String> deleteCommande(Long id) {
        CommandeFournisseur commandeFournisseur = commandeFournisseurRepository.findById(id).orElseThrow(()-> new RessourceNotFoundException(" La Ligne de commande fournisseur avec l'id : "+id+" n'existe pas"));
        return ResponseEntity.ok("commande supprimer avec succès");
    }

    @Override
    public CommandeFournisseur getCommandeByCode(String code) {
        CommandeFournisseur commandeFournisseur = commandeFournisseurRepository.findByCode(code);
        if (commandeFournisseur == null) {
            throw new RessourceNotFoundException("la commande fournisseur n'existe pas");
        }
        else {
            return commandeFournisseur;
        }
    }

    @Override
    public List<CommandeFournisseur> getAllCommandeFournisseur() {
        return commandeFournisseurRepository.findAll();
    }
}
