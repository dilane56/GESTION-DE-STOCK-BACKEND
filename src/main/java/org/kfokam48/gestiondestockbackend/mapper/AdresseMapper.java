package org.kfokam48.gestiondestockbackend.mapper;

import org.kfokam48.gestiondestockbackend.dto.AdresseDto;
import org.kfokam48.gestiondestockbackend.model.Adresse;
import org.modelmapper.ModelMapper;

public class AdresseMapper {
    private final ModelMapper modelMapper;

    public AdresseMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public AdresseDto adresseToAdresseDto(Adresse adresse) {
        return modelMapper.map(adresse, AdresseDto.class);
    }

    public Adresse adresseDtoToAdresse(AdresseDto dto) {
        return modelMapper.map(dto, Adresse.class);
    }

}
