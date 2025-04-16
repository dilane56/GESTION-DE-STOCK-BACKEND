package org.kfokam48.gestiondestockbackend.mapper;

import org.kfokam48.gestiondestockbackend.dto.FournisseurDto;
import org.kfokam48.gestiondestockbackend.model.Fournisseur;
import org.modelmapper.ModelMapper;

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
}
