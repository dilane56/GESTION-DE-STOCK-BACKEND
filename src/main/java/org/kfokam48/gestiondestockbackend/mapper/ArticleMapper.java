package org.kfokam48.gestiondestockbackend.mapper;

import org.kfokam48.gestiondestockbackend.dto.ArticleDto;
import org.kfokam48.gestiondestockbackend.model.Article;
import org.modelmapper.ModelMapper;

public class ArticleMapper {
    private final ModelMapper modelMapper;

    public ArticleMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Article articleToArticle(Article article) {
        return modelMapper.map(article, Article.class);
    }

    public ArticleDto articleToArticleDto(Article article) {
        return modelMapper.map(article, ArticleDto.class);
    }

}
