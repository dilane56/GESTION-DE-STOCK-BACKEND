package org.kfokam48.gestiondestockbackend.mapper;

import org.kfokam48.gestiondestockbackend.dto.EntrepriseDto;
import org.kfokam48.gestiondestockbackend.dto.UtilisateurDto;
import org.kfokam48.gestiondestockbackend.model.Entreprise;
import org.kfokam48.gestiondestockbackend.model.Utilisateur;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class EntrepriseMapper {
    private final ModelMapper modelMapper;

    public EntrepriseMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public Entreprise entrepriseDtoToEntreprise(EntrepriseDto entrepriseDto) {
        return modelMapper.map(entrepriseDto, Entreprise.class);
    }

    public EntrepriseDto entrepriseToEntrepriseDto(Entreprise entreprise) {
        return modelMapper.map(entreprise, EntrepriseDto.class);
    }
    public List<Utilisateur> utilisateursDtoListToUtilisateursList(List<UtilisateurDto> utilisateurDtoList) {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        for (UtilisateurDto utilisateurDto : utilisateurDtoList) {
            utilisateurs.add(modelMapper.map(utilisateurDto, Utilisateur.class));
        }
        return utilisateurs;
    }
}
