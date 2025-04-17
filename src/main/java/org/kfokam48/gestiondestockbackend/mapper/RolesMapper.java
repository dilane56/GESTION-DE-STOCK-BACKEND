package org.kfokam48.gestiondestockbackend.mapper;

import org.kfokam48.gestiondestockbackend.dto.RoleDto;
import org.kfokam48.gestiondestockbackend.model.Roles;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RolesMapper {
    private final ModelMapper modelMapper;

    public RolesMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Roles roleDtoToRole(RoleDto roleDto) {
        return modelMapper.map(roleDto, Roles.class);
    }

    public RoleDto roleToRoleDto(Roles roles) {
        return modelMapper.map(roles, RoleDto.class);
    }
}
