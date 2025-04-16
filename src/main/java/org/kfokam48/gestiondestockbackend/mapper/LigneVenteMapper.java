package org.kfokam48.gestiondestockbackend.mapper;

import org.kfokam48.gestiondestockbackend.dto.LigneVenteDto;
import org.kfokam48.gestiondestockbackend.model.LigneVente;
import org.modelmapper.ModelMapper;

public class LigneVenteMapper {
    private final ModelMapper modelMapper;

    public LigneVenteMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public LigneVente ligneVenteDtoToLigneVente(LigneVenteDto ligneVenteDto) {
        return modelMapper.map(ligneVenteDto, LigneVente.class);
    }

    public LigneVenteDto ligneVenteToLigneVenteDto(LigneVente ligneVente) {
        return modelMapper.map(ligneVente, LigneVenteDto.class);
    }
}
