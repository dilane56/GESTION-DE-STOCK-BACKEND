package org.kfokam48.gestiondestockbackend.service;

import jakarta.validation.Valid;
import org.kfokam48.gestiondestockbackend.dto.ArticleDto;
import org.kfokam48.gestiondestockbackend.exception.RessourceNotFoundException;
import org.kfokam48.gestiondestockbackend.mapper.ArticleMapper;
import org.kfokam48.gestiondestockbackend.model.Article;
import org.kfokam48.gestiondestockbackend.repository.ArticleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleMapper articleMapper;

    public ArticleServiceImpl(ArticleRepository articleRepository, ArticleMapper articleMapper) {
        this.articleRepository = articleRepository;
        this.articleMapper = articleMapper;
    }

    @Override
    public Article save(@Valid ArticleDto articleDto) {
        return articleRepository.save(articleMapper.articleDtoToArticle(articleDto)) ;
    }

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public Article findById(Long id) {
        return articleRepository.findById(id).orElseThrow(()-> new RessourceNotFoundException("Aucun article trouvé avec l'id: "+id));
    }

    @Override
    public Article update(Long id,@Valid ArticleDto articleDto) {
        Article article = articleRepository.findById(id).orElseThrow(()-> new RessourceNotFoundException("Aucun article trouvé avec l'id: "+id));

        article = articleRepository.save(articleMapper.articleDtoToArticle(articleDto));
        return article;
    }

    @Override
    public Article findByCode(String code) {
        return articleRepository.findByCodeArticle(code);
    }

    @Override
    public ResponseEntity<String> delete(Long id) {
        Article article = articleRepository.findById(id).orElseThrow(()-> new RessourceNotFoundException("Aucun article trouvé avec l'id: "+id));
        articleRepository.deleteById(id);
        return ResponseEntity.ok().body("Article supprimer avec succès");
    }
}
