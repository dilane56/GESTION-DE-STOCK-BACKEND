package org.kfokam48.gestiondestockbackend.mapper;

import org.kfokam48.gestiondestockbackend.dto.CommandeFournisseurDto;
import org.kfokam48.gestiondestockbackend.dto.LigneCommandeClientDto;
import org.kfokam48.gestiondestockbackend.dto.LigneCommandeFournisseurDto;
import org.kfokam48.gestiondestockbackend.model.CommandeFournisseur;
import org.kfokam48.gestiondestockbackend.model.LigneCommandeClient;
import org.kfokam48.gestiondestockbackend.model.LigneCommandeFournisseur;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class CommandeFournisseurMapper {
    private final ModelMapper modelMapper;

    public CommandeFournisseurMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public CommandeFournisseur commandeFournisseurDtotoCommandeFournisseur(CommandeFournisseurDto commandeFournisseurDto) {
        return modelMapper.map(commandeFournisseurDto, CommandeFournisseur.class);
    }

    public CommandeFournisseurDto commandeFournisseurtoCommandeFournisseurDto(CommandeFournisseur commandeFournisseur) {
        return modelMapper.map(commandeFournisseur, CommandeFournisseurDto.class);
    }
   public List<LigneCommandeFournisseur> ligneCommandeFournisseursDtoToLigneCommandeFournisseur (List<LigneCommandeFournisseurDto> ligneCommandeFournisseurDtolist) {
        List<LigneCommandeFournisseur> ligneCommandeFournisseurs = new ArrayList<>();
        for(LigneCommandeFournisseurDto ligneCommandeFournisseurDto:ligneCommandeFournisseurDtolist){
            LigneCommandeFournisseur ligneCommandeFournisseur = modelMapper.map(ligneCommandeFournisseurDto, LigneCommandeFournisseur.class);
            ligneCommandeFournisseurs.add(ligneCommandeFournisseur);
        }
        return ligneCommandeFournisseurs;
   }
}
