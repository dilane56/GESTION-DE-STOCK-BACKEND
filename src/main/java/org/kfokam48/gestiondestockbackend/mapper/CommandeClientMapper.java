package org.kfokam48.gestiondestockbackend.mapper;

import org.kfokam48.gestiondestockbackend.dto.CommandeClientDto;
import org.kfokam48.gestiondestockbackend.model.CommandeClient;
import org.modelmapper.ModelMapper;

public class CommandeClientMapper {
    private final ModelMapper modelMapper;

    public CommandeClientMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CommandeClient commandeClientDtoToCommandeClient(CommandeClientDto commandeClientDto) {
        return modelMapper.map(commandeClientDto, CommandeClient.class);
    }
    public CommandeClientDto commandeClientToCommandeClient(CommandeClient commandeClient) {
        return modelMapper.map(commandeClient, CommandeClientDto.class);
    }
}
