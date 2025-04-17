package org.kfokam48.gestiondestockbackend.mapper;

import org.kfokam48.gestiondestockbackend.dto.RoleDto;
import org.kfokam48.gestiondestockbackend.dto.UtilisateurDto;
import org.kfokam48.gestiondestockbackend.model.Roles;
import org.kfokam48.gestiondestockbackend.model.Utilisateur;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
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
    public List<Roles> rolesDtolistTorolesList(List<RoleDto> roleDtosList) {
        List<Roles> rolesList = new ArrayList<>();
        for (RoleDto roleDto : roleDtosList) {
            Roles roles = modelMapper.map(roleDto, Roles.class);
            rolesList.add(roles);
        }
        return rolesList;
    }
}
