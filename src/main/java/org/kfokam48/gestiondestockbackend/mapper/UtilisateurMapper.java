package org.kfokam48.gestiondestockbackend.mapper;

import org.kfokam48.gestiondestockbackend.dto.UtilisateurDto;
import org.kfokam48.gestiondestockbackend.model.Utilisateur;
import org.modelmapper.ModelMapper;

public class UtilisateurMapper {
    private final ModelMapper modelMapper;

    public UtilisateurMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Utilisateur utilisateurDtoToUtilisateur(UtilisateurDto utilisateurDto) {
        return modelMapper.map(utilisateurDto, Utilisateur.class);
    }

    public UtilisateurDto utilisateurToUtilisateurDto(Utilisateur utilisateur) {
        return modelMapper.map(utilisateur, UtilisateurDto.class);
    }
}
