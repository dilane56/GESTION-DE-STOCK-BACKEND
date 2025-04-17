package org.kfokam48.gestiondestockbackend.service;

import jakarta.validation.Valid;
import org.kfokam48.gestiondestockbackend.dto.MvtStkDto;
import org.kfokam48.gestiondestockbackend.exception.RessourceNotFoundException;
import org.kfokam48.gestiondestockbackend.mapper.ArticleMapper;
import org.kfokam48.gestiondestockbackend.mapper.MvtStkMapper;
import org.kfokam48.gestiondestockbackend.model.MvtStk;
import org.kfokam48.gestiondestockbackend.repository.MvtStkRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MvtStkServiceImpl implements MvtStkService {
    private MvtStkRepository mvtStkRepository;
    private MvtStkMapper mvtStkMapper;
    private ArticleMapper articleMapper;

    public MvtStkServiceImpl(MvtStkRepository mvtStkRepository, MvtStkMapper mvtStkMapper) {
        this.mvtStkRepository = mvtStkRepository;
        this.mvtStkMapper = mvtStkMapper;
    }

    @Override
    public MvtStk getMvtStkById(Long id) {
        return mvtStkRepository.findById(id).orElseThrow(()->new RessourceNotFoundException("not found"));
    }

    @Override
    public List<MvtStk> getMvtStkList() {
        return mvtStkRepository.findAll();
    }

    @Override
    public MvtStk createMvtStk(@Valid MvtStkDto mvtStkDto) {
        return mvtStkRepository.save(mvtStkMapper.mvtStkDtotoMvtStk(mvtStkDto));
    }

    @Override
    public ResponseEntity<String> deleteMvtStkById(Long id) {
        MvtStk mvtStk =  mvtStkRepository.findById(id).orElseThrow(()->new RessourceNotFoundException("not found"));
        mvtStkRepository.deleteById(id);
        return ResponseEntity.ok("Deleted MvtStk");
    }

    @Override
    public MvtStk updateMvtStk( Long id ,@Valid MvtStkDto mvtStkDto) {
     MvtStk mvtStk =  mvtStkRepository.findById(id).orElseThrow(()->new RessourceNotFoundException("not found"));
     mvtStk.setDateMvt(mvtStkDto.getDateMvt());
     mvtStk.setQuantite(mvtStkDto.getQuantite());
     mvtStk.setArticle(articleMapper.articleDtoToArticle(mvtStkDto.getArticle()));
        return mvtStkRepository.save(mvtStk);
    }
}
