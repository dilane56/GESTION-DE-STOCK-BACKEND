package org.kfokam48.gestiondestockbackend.mapper;

import org.kfokam48.gestiondestockbackend.dto.LigneCommandeClientDto;
import org.kfokam48.gestiondestockbackend.model.LigneCommandeClient;
import org.modelmapper.ModelMapper;

public class LigneCommandeClientMapper {
    private final ModelMapper modelMapper;

    public LigneCommandeClientMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public LigneCommandeClient ligneCommandeClientDtoToLigneCommandeClientDto(LigneCommandeClient ligneCommandeClientDto) {
        return modelMapper.map(ligneCommandeClientDto, LigneCommandeClient.class);
    }

    public LigneCommandeClientDto ligneCommandeClientToLigneCommandeClientDto(LigneCommandeClient ligneCommandeClient) {
        return modelMapper.map(ligneCommandeClient, LigneCommandeClientDto.class);
    }
}
