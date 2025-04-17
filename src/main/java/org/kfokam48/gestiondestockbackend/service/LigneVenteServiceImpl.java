package org.kfokam48.gestiondestockbackend.service;

import org.kfokam48.gestiondestockbackend.dto.LigneVenteDto;
import org.kfokam48.gestiondestockbackend.exception.RessourceNotFoundException;
import org.kfokam48.gestiondestockbackend.mapper.LigneVenteMapper;
import org.kfokam48.gestiondestockbackend.mapper.VentesMapper;
import org.kfokam48.gestiondestockbackend.model.LigneVente;
import org.kfokam48.gestiondestockbackend.repository.LigneVenteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LigneVenteServiceImpl implements LigneVenteService {
    private final LigneVenteRepository ligneVenteRepository;
    private final LigneVenteMapper ligneVenteMapper;
    private final VentesMapper ventesMapper;

    public LigneVenteServiceImpl(LigneVenteRepository ligneVenteRepository, LigneVenteMapper ligneVenteMapper, VentesMapper ventesMapper) {
        this.ligneVenteRepository = ligneVenteRepository;
        this.ligneVenteMapper = ligneVenteMapper;
        this.ventesMapper = ventesMapper;
    }

    @Override
    public LigneVente getLigneVenteById(Long id) {
        return ligneVenteRepository.findById(id).orElseThrow(()->new RessourceNotFoundException("LigneVente not found"));
    }

    @Override
    public List<LigneVente> getLigneVentes() {
        return ligneVenteRepository.findAll();
    }

    @Override
    public LigneVente save(LigneVenteDto ligneVenteDto) {
        return ligneVenteRepository.save(ligneVenteMapper.ligneVenteDtoToLigneVente(ligneVenteDto));
    }

    @Override
    public ResponseEntity<String> delete(Long id) {

        LigneVente ligneVente = ligneVenteRepository.findById(id).orElseThrow(()->new RessourceNotFoundException("LigneVente not found"));
        ligneVenteRepository.deleteById(id);
        return ResponseEntity.ok("LigneVente deleted");
    }

    @Override
    public LigneVente update(Long id, LigneVenteDto ligneVenteDto) {
        LigneVente ligneVente = ligneVenteRepository.findById(id).orElseThrow(()->new RessourceNotFoundException("LigneVente not found"));
        ligneVente.setVente(ventesMapper.ventesDtoToVentes(ligneVenteDto.getVente()));
        ligneVente.setQuantite(ligneVenteDto.getQuantite());
        ligneVente.setPrixUnitaire(ligneVenteDto.getPrixUnitaire());
        ligneVenteRepository.save(ligneVente);
        return ligneVente;
    }
}
