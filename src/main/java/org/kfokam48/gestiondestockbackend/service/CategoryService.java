package org.kfokam48.gestiondestockbackend.service;

import org.kfokam48.gestiondestockbackend.dto.CategoryDto;
import org.kfokam48.gestiondestockbackend.model.Category;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {
    Category getCategoryById(Long id);
    Category findByCode(String code);
    List<Category> getAllCategories();
    Category saveCategory(CategoryDto categoryDto);
    Category updateCategory(Long id,CategoryDto categoryDto);
    ResponseEntity<String> deleteCategory(Long id);
}
