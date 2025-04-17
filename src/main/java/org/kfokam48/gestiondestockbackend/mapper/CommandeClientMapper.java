package org.kfokam48.gestiondestockbackend.mapper;

import lombok.Data;
import org.kfokam48.gestiondestockbackend.dto.CommandeClientDto;
import org.kfokam48.gestiondestockbackend.dto.LigneCommandeClientDto;
import org.kfokam48.gestiondestockbackend.model.CommandeClient;
import org.kfokam48.gestiondestockbackend.model.LigneCommandeClient;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
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

   public List<LigneCommandeClient> ligneCommandeClientsDtoToLigneCommandeClient(List<LigneCommandeClientDto> ligneCommandeClientsDto) {
        List<LigneCommandeClient> ligneCommandeClients = new ArrayList<>();
        for(LigneCommandeClientDto ligneCommandeClientDto :ligneCommandeClientsDto ){
           LigneCommandeClient ligneCommandeClient = modelMapper.map(ligneCommandeClientDto, LigneCommandeClient.class);
           ligneCommandeClients.add(ligneCommandeClient);
        }
        return ligneCommandeClients;
    }

}
