package org.kfokam48.gestiondestockbackend.service;

import jakarta.validation.Valid;
import org.kfokam48.gestiondestockbackend.dto.CommandeClientDto;
import org.kfokam48.gestiondestockbackend.exception.RessourceNotFoundException;
import org.kfokam48.gestiondestockbackend.mapper.ClientMapper;
import org.kfokam48.gestiondestockbackend.mapper.CommandeClientMapper;
import org.kfokam48.gestiondestockbackend.model.CommandeClient;
import org.kfokam48.gestiondestockbackend.repository.CommandeClientRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommandeClientServiceImpl implements CommandeClientService {
    private final CommandeClientRepository commandeClientRepository;
    private final ClientMapper clientMapper;
    private final CommandeClientMapper commandeClientMapper;

    public CommandeClientServiceImpl(CommandeClientRepository commandeClientRepository, ClientMapper clientMapper, CommandeClientMapper commandeClientMapper) {
        this.commandeClientRepository = commandeClientRepository;
        this.clientMapper = clientMapper;
        this.commandeClientMapper = commandeClientMapper;
    }

    @Override
    public CommandeClient getCommandeClientById(Long id) {
        return commandeClientRepository.findById(id).orElseThrow(()-> new RessourceNotFoundException("CommandeClient not found with id: "+id));
    }

    @Override
    public CommandeClient findCommandeByCode(String code) {
        return null;
    }

    @Override
    public List<CommandeClient> getAllCommandeClients() {
        return commandeClientRepository.findAll();
    }

    @Override
    public CommandeClient addCommandeClient(@Valid CommandeClientDto commandeClientDto) {
        return commandeClientRepository.save(commandeClientMapper.commandeClientDtoToCommandeClient(commandeClientDto));
    }

    @Override
    public CommandeClient updateCommandeClient(Long id,@Valid CommandeClientDto commandeClientDto) {
        CommandeClient commandeClient = commandeClientRepository.findById(id).orElseThrow(()-> new RessourceNotFoundException("CommandeClient not found with id: "+id));
        commandeClient.setCode(commandeClientDto.getCode());
        commandeClient.setDateCommande(commandeClientDto.getDateCommande());
        commandeClient.setClient(clientMapper.clientDtoToClient(commandeClientDto.getClient()));
        commandeClient.setLigneCommandeClients(commandeClientMapper.ligneCommandeClientsDtoToLigneCommandeClient(commandeClientDto.getLigneCommandeClients()));
        return null;
    }

    @Override
    public ResponseEntity<String> deleteCommandeClient(Long id) {
        CommandeClient commandeClient = commandeClientRepository.findById(id).orElseThrow(()-> new RessourceNotFoundException("CommandeClient not found with id: "+id));
        commandeClientRepository.delete(commandeClient);
        return ResponseEntity.ok("CommandeClient deleted");
    }
}
