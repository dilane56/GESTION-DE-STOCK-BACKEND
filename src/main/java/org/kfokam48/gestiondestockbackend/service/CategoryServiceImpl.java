package org.kfokam48.gestiondestockbackend.service;

import jakarta.validation.Valid;
import org.kfokam48.gestiondestockbackend.dto.CategoryDto;
import org.kfokam48.gestiondestockbackend.exception.RessourceNotFoundException;
import org.kfokam48.gestiondestockbackend.mapper.CategoryMapper;
import org.kfokam48.gestiondestockbackend.model.Category;
import org.kfokam48.gestiondestockbackend.repository.CategoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RessourceNotFoundException("Category avec l'id : "+id +"n'existe pas"));

    }

    @Override
    public Category findByCode(String code) {
        Category category= categoryRepository.findByCode(code);
        if(category==null){
            throw new RessourceNotFoundException("La Catégorie avec le code: "+code+" n'existe pas");
        }else{
            return category;
        }
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category saveCategory(@Valid CategoryDto categoryDto) {
        return categoryRepository.save(categoryMapper.categoryDtotoCategory(categoryDto));
    }

    @Override
    public Category updateCategory(Long id,@Valid CategoryDto categoryDto) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RessourceNotFoundException("Category avec l'id : "+id +"n'existe pas"));
        category.setCode(categoryDto.getCode());
        category.setDesignation( categoryDto.getDesignation());
        if(categoryDto.getArticles() != null) {
            category.setArticles(categoryMapper.articleDtoListToArticleList(categoryDto.getArticles()));

        }
        return categoryRepository.save(category);
    }

    @Override
    public ResponseEntity<String> deleteCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RessourceNotFoundException("Category avec l'id : "+id +"n'existe pas"));
        categoryRepository.deleteById(id);
        return ResponseEntity.ok("Catégorie supprimer avec succès");
    }
}
