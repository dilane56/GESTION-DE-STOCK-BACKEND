package org.kfokam48.gestiondestockbackend.mapper;

import org.kfokam48.gestiondestockbackend.dto.ArticleDto;
import org.kfokam48.gestiondestockbackend.dto.CategoryDto;
import org.kfokam48.gestiondestockbackend.model.Article;
import org.kfokam48.gestiondestockbackend.model.Category;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;
@Component
public class CategoryMapper {
    private final ModelMapper modelMapper;

    public CategoryMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public Category categoryDtotoCategory(CategoryDto categoryDto) {
        return modelMapper.map(categoryDto, Category.class);
    }

    public CategoryDto categoryCategoryToCategoryDto(Category category) {
        return modelMapper.map(category, CategoryDto.class);
    }
    public List<Article> articleDtoListToArticleList(List<ArticleDto> articleDtoList) {
        List<Article> articlesList = new ArrayList<>();
      for(ArticleDto articleDto : articleDtoList) {
          Article article = modelMapper.map(articleDto, Article.class);
          articlesList.add(article);
      }
      return articlesList;
    }

}
