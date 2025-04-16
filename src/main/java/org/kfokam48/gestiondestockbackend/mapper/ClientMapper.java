package org.kfokam48.gestiondestockbackend.mapper;

import org.kfokam48.gestiondestockbackend.dto.ClientDto;
import org.kfokam48.gestiondestockbackend.model.Client;
import org.modelmapper.ModelMapper;

public class ClientMapper {
    private final ModelMapper modelMapper;

    public ClientMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Client clientDtoToClient(ClientDto clientDto) {
        return modelMapper.map(clientDto, Client.class);
    }
    public ClientDto clientToClientDto(Client client) {
        return modelMapper.map(client, ClientDto.class);
    }
}
