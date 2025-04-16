package org.kfokam48.gestiondestockbackend.mapper;

import org.kfokam48.gestiondestockbackend.dto.CommandeFournisseurDto;
import org.kfokam48.gestiondestockbackend.model.CommandeFournisseur;
import org.modelmapper.ModelMapper;

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
}
