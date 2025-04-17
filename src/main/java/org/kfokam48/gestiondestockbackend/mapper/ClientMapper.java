package org.kfokam48.gestiondestockbackend.mapper;

import org.kfokam48.gestiondestockbackend.dto.ClientDto;
import org.kfokam48.gestiondestockbackend.dto.CommandeClientDto;
import org.kfokam48.gestiondestockbackend.model.Client;
import org.kfokam48.gestiondestockbackend.model.CommandeClient;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
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

    public List<CommandeClient> commandeClientDtoListToCommandeClientList(List<CommandeClientDto> commandeClientDtoList) {
        List<CommandeClient> commandeClientList = new ArrayList<>();
        for (CommandeClientDto commandeClientDto : commandeClientDtoList) {
            commandeClientList.add(modelMapper.map(commandeClientDto, CommandeClient.class));
        }
        return commandeClientList;
    }
}
