package org.kfokam48.gestiondestockbackend.mapper;

import org.kfokam48.gestiondestockbackend.dto.CommandeFournisseurDto;
import org.kfokam48.gestiondestockbackend.dto.FournisseurDto;
import org.kfokam48.gestiondestockbackend.model.CommandeFournisseur;
import org.kfokam48.gestiondestockbackend.model.Fournisseur;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class FournisseurMapper {
    private final ModelMapper modelMapper;

    public FournisseurMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public Fournisseur fournisseurDtotoFournisseur(FournisseurDto fournisseurDto) {
        return modelMapper.map(fournisseurDto, Fournisseur.class);
    }

    public FournisseurDto fournisseurtoFournisseurDto(Fournisseur fournisseur) {
        return modelMapper.map(fournisseur, FournisseurDto.class);
    }
    public List<CommandeFournisseur> commandeFournisseurListDtoToCommandeFournisseurList (List<CommandeFournisseurDto> commandeFournisseurDtoList)
    {
        List<CommandeFournisseur> commandeFournisseurList =new ArrayList<>();
        for(CommandeFournisseurDto commandeFournisseurDto:commandeFournisseurDtoList){
           CommandeFournisseur commandeFournisseur = modelMapper.map(commandeFournisseurDto, CommandeFournisseur.class);
           commandeFournisseurList.add(commandeFournisseur);
        }
        return commandeFournisseurList;

    }
}
