package org.kfokam48.gestiondestockbackend.controller;

import jakarta.validation.Valid;
import org.kfokam48.gestiondestockbackend.dto.CategoryDto;
import org.kfokam48.gestiondestockbackend.model.Category;
import org.kfokam48.gestiondestockbackend.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping
    public Category createCategory(@Valid @RequestBody CategoryDto category) {
        return categoryService.saveCategory(category);
    }

    @PutMapping("/update/{id}")
    public Category updateCategory(@PathVariable Long id, @Valid @RequestBody CategoryDto categoryDto) {
        return categoryService.updateCategory(id, categoryDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
        return categoryService.deleteCategory(id);
    }
}
