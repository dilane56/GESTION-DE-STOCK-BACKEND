package org.kfokam48.gestiondestockbackend.service;

import jakarta.validation.Valid;
import org.kfokam48.gestiondestockbackend.dto.VentesDto;
import org.kfokam48.gestiondestockbackend.exception.RessourceNotFoundException;
import org.kfokam48.gestiondestockbackend.mapper.VentesMapper;
import org.kfokam48.gestiondestockbackend.model.Ventes;
import org.kfokam48.gestiondestockbackend.repository.VentesRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VentesServiceImpl implements VentesService {
    private final VentesRepository ventesRepository;
    private final VentesMapper ventesMapper;

    public VentesServiceImpl(VentesRepository ventesRepository, VentesMapper ventesMapper) {
        this.ventesRepository = ventesRepository;
        this.ventesMapper = ventesMapper;
    }

    @Override
    public Ventes findVenteById(Long id) {
        Ventes vente = ventesRepository.findById(id).orElseThrow(()->new RessourceNotFoundException("Ventes not Found with ID: "+id));
        return null;
    }

    @Override
    public Ventes findVenteByCode(String code) {
        return null;
    }

    @Override
    public List<Ventes> findAllVentes() {
        return ventesRepository.findAll();
    }

    @Override
    public Ventes saveVente(@Valid VentesDto ventesDto) {
        return ventesRepository.save(ventesMapper.ventesDtoToVentes(ventesDto));
    }

    @Override
    public Ventes updateVente(Long id,@Valid VentesDto ventesDto) {

        Ventes vente = ventesRepository.findById(id).orElseThrow(()->new RessourceNotFoundException("Ventes not Found with ID: "+id));
        vente.setCode(ventesDto.getCode());
        vente.setDateVente(ventesDto.getDateVente());
        vente.setCommentaire(ventesDto.getCommentaire());
        ventesRepository.save(vente);
        return vente;
    }

    @Override
    public ResponseEntity<String> deleteVente(Long id) {
        Ventes vente = ventesRepository.findById(id).orElseThrow(()->new RessourceNotFoundException("Ventes not Found with ID: "+id));
        ventesRepository.deleteById(id);
        return ResponseEntity.ok("Ventes deleted successfully");
    }
}
