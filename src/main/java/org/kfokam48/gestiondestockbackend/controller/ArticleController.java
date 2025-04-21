package org.kfokam48.gestiondestockbackend.controller;

import jakarta.validation.Valid;
import org.kfokam48.gestiondestockbackend.dto.ArticleDto;
import org.kfokam48.gestiondestockbackend.model.Article;
import org.kfokam48.gestiondestockbackend.service.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/articles")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Operation(summary = "Récupérer la liste des articles", description = "Retourne tous les articles disponibles en base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des articles récupérée avec succès")
    })
    @GetMapping
    public List<Article> getAllArticles() {
        return articleService.findAll();
    }

    @Operation(summary = "Récupérer un article par ID", description = "Retourne un article spécifique en fonction de son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Article récupéré avec succès"),
            @ApiResponse(responseCode = "404", description = "Article introuvable")
    })
    @GetMapping("/{id}")
    public Article getArticleById(@PathVariable long id) {
        return articleService.findById(id);
    }

    @Operation(summary = "Créer un nouvel article", description = "Ajoute un nouvel article en base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Article créé avec succès"),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })
    @PostMapping
    public Article createArticle(@Valid @RequestBody ArticleDto article) {
        return articleService.save(article);
    }

    @Operation(summary = "Mettre à jour un article", description = "Modifie un article existant en base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Article mis à jour avec succès"),
            @ApiResponse(responseCode = "404", description = "Article introuvable"),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })
    @PutMapping("/update/{id}")
    public Article updateArticle(@PathVariable long id, @Valid @RequestBody ArticleDto article) {
        return articleService.update(id, article);
    }

    @Operation(summary = "Supprimer un article", description = "Supprime un article en fonction de son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Article supprimé avec succès"),
            @ApiResponse(responseCode = "404", description = "Article introuvable")
    })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteArticle(@PathVariable long id) {
        return articleService.delete(id);
    }
}