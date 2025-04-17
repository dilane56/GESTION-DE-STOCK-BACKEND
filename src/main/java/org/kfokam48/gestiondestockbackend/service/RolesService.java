package org.kfokam48.gestiondestockbackend.service;

import org.kfokam48.gestiondestockbackend.dto.RoleDto;
import org.kfokam48.gestiondestockbackend.model.Roles;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RolesService {

    Roles getRolesById(Long id);
    Roles getRolesByName(String roleName);
    List<Roles> getAllRoles();
    Roles addRole(RoleDto roleDto);
    Roles updateRole( Long id, RoleDto roleDto);
    ResponseEntity<String> deleteRole(Long id);
}
