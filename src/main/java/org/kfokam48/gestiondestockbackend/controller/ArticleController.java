package org.kfokam48.gestiondestockbackend.controller;

import jakarta.validation.Valid;
import org.kfokam48.gestiondestockbackend.dto.ArticleDto;
import org.kfokam48.gestiondestockbackend.model.Article;
import org.kfokam48.gestiondestockbackend.service.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/articles")
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }
    @GetMapping
    public List<Article> getAllArticles() {
        return articleService.findAll();
    }

    @GetMapping("/{id}")
    public Article getArticleById(@PathVariable long id) {
        return articleService.findById(id);
    }
    @PostMapping
    public Article createArticle(@Valid @RequestBody ArticleDto article) {
        return articleService.save(article);
    }
    @PutMapping("/update/{id}")
    public Article updateArticle(@PathVariable long id, @Valid @RequestBody ArticleDto article) {
        return articleService.update(id, article);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteArticle(@PathVariable long id) {
        return articleService.delete(id);
    }
}
