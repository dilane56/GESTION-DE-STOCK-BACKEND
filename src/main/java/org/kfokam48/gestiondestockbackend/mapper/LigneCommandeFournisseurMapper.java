package org.kfokam48.gestiondestockbackend.mapper;

import org.kfokam48.gestiondestockbackend.dto.LigneCommandeFournisseurDto;
import org.kfokam48.gestiondestockbackend.model.LigneCommandeFournisseur;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class LigneCommandeFournisseurMapper {
    private final ModelMapper modelMapper;

    public LigneCommandeFournisseurMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public LigneCommandeFournisseur ligneCommandeFournisseurDtoToLigneCommandeFournisseur(LigneCommandeFournisseurDto ligneCommandeFournisseurDto){
        return modelMapper.map(ligneCommandeFournisseurDto, LigneCommandeFournisseur.class);
    }

    public LigneCommandeFournisseurDto ligneCommandeFournisseurtoLigneCommandeFournisseurDto(LigneCommandeFournisseur ligneCommandeFournisseur){
        return modelMapper.map(ligneCommandeFournisseur, LigneCommandeFournisseurDto.class);
    }
}
