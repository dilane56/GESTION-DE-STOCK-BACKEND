package org.kfokam48.gestiondestockbackend.service;

import org.kfokam48.gestiondestockbackend.dto.RoleDto;
import org.kfokam48.gestiondestockbackend.exception.RessourceNotFoundException;
import org.kfokam48.gestiondestockbackend.mapper.RolesMapper;
import org.kfokam48.gestiondestockbackend.mapper.UtilisateurMapper;
import org.kfokam48.gestiondestockbackend.model.Roles;
import org.kfokam48.gestiondestockbackend.repository.RolesRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RolesServiceImpl implements RolesService {
    private final RolesRepository rolesRepository;
    private final RolesMapper rolesMapper;
    private final UtilisateurMapper utilisateurMapper;

    public RolesServiceImpl(RolesRepository rolesRepository, RolesMapper rolesMapper, UtilisateurMapper utilisateurMapper) {
        this.rolesRepository = rolesRepository;
        this.rolesMapper = rolesMapper;
        this.utilisateurMapper = utilisateurMapper;
    }

    @Override
    public Roles getRolesById(Long id) {
        return rolesRepository.findById(id).orElseThrow(() -> new RessourceNotFoundException("Roles not found"));
    }

    @Override
    public Roles getRolesByName(String roleName) {
        return null;
    }

    @Override
    public List<Roles> getAllRoles() {
        return rolesRepository.findAll();
    }

    @Override
    public Roles addRole(RoleDto roleDto) {
        return rolesRepository.save(rolesMapper.roleDtoToRole(roleDto));
    }

    @Override
    public Roles updateRole(Long id, RoleDto roleDto) {

        Roles roles = rolesRepository.findById(id).orElseThrow(() -> new RessourceNotFoundException("Roles not found"));
        roles.setRoleName(roleDto.getRoleName());
        roles.setUtilisateur(utilisateurMapper.utilisateurDtoToUtilisateur(roleDto.getUtilisateur()));
        rolesRepository.save(roles);
        return roles;
    }

    @Override
    public ResponseEntity<String> deleteRole(Long id) {
        Roles roles = rolesRepository.findById(id).orElseThrow(() -> new RessourceNotFoundException("Roles not found"));
        rolesRepository.deleteById(id);
        return ResponseEntity.ok("Roles deleted successfully");
    }
}
