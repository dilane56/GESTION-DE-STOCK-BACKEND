package org.kfokam48.gestiondestockbackend.mapper;

import org.kfokam48.gestiondestockbackend.dto.EntrepriseDto;
import org.kfokam48.gestiondestockbackend.model.Entreprise;
import org.modelmapper.ModelMapper;

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
}
