package org.kfokam48.gestiondestockbackend.service;

import org.kfokam48.gestiondestockbackend.dto.ArticleDto;
import org.kfokam48.gestiondestockbackend.model.Article;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ArticleService {
    Article save(ArticleDto articleDto);
    List<Article> findAll();
    Article findById(Long id);
    Article update(Long id, ArticleDto articleDto);
    Article findByCode(String code);
    ResponseEntity<String> delete(Long id);
}
