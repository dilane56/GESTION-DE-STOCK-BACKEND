package org.kfokam48.gestiondestockbackend.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.kfokam48.gestiondestockbackend.dto.CategoryDto;
import org.kfokam48.gestiondestockbackend.exception.RessourceNotFoundException;
import org.kfokam48.gestiondestockbackend.mapper.CategoryMapper;
import org.kfokam48.gestiondestockbackend.model.Category;
import org.kfokam48.gestiondestockbackend.repository.CategoryRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class CategoryServiceImplTest {
    private CategoryRepository categoryRepository;
    private CategoryMapper categoryMapper;
    private CategoryServiceImpl categoryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        categoryRepository = mock(CategoryRepository.class);
        categoryMapper = mock(CategoryMapper.class);
        categoryService = new CategoryServiceImpl(categoryRepository, categoryMapper);
    }

    @Test
    void testGetCategoryById() {
        Long id = 1L;
        Category category = new Category();
        category.setId(id);

        when(categoryRepository.findById(id)).thenReturn(Optional.of(category));
        when(categoryMapper.categoryDtotoCategory(any(CategoryDto.class))).thenReturn(category);
        Category category1 = categoryService.getCategoryById(1L);
        assertNotNull(category1);
        assertEquals(1L, category1.getId());
    }

    @Test
    void testGetCategoryById_NotFound() {
        assertThrows(RessourceNotFoundException.class, () -> categoryService.getCategoryById(99L));
    }

    @Test
    void testFindByCode() {
        String code = "CAT001";
        Category category = new Category();
        category.setCode(code);

        when(categoryRepository.findByCode(code)).thenReturn(category);
        when(categoryMapper.categoryDtotoCategory(any(CategoryDto.class))).thenReturn(category);
        Category category1 = categoryService.findByCode("CAT001");
        assertNotNull(category1);
        assertEquals("CAT001", category1.getCode());
    }

    @Test
    void testFindByCode_NotFound() {
        String code = "CAT001";

        when(categoryRepository.findByCode(code)).thenReturn(null);
        when(categoryMapper.categoryDtotoCategory(any(CategoryDto.class))).thenReturn(null);
        assertThrows(RessourceNotFoundException.class, () -> categoryService.findByCode(code));
        verify(categoryRepository, times(1)).findByCode(code);


    }

    @Test
    void testGetAllCategories() {
        Category category = new Category();
        category.setCode("NEW_CAT");
        category.setDesignation("New Category");
        categoryRepository.save(category);

        when(categoryRepository.findAll()).thenReturn(List.of(category));
        when(categoryMapper.categoryDtotoCategory(any(CategoryDto.class))).thenReturn(category);
        when(categoryRepository.findByCode(category.getCode())).thenReturn(category);
        List<Category> categories = categoryService.getAllCategories();
        assertNotNull(categories);
        assertFalse(categories.isEmpty());
    }

    @Test
    void testSaveCategory() {
        Category category = new Category();
        category.setCode("NEW_CAT");
        category.setDesignation("New Category");

        CategoryDto categoryDto = CategoryDto.builder()
                .code("NEW_CAT")
                .designation("New Category")
                .build();

        when(categoryMapper.categoryDtotoCategory(categoryDto)).thenReturn(category);
        when(categoryRepository.save(category)).thenReturn(category);

        Category result = categoryService.saveCategory(categoryDto);

        assertNotNull(result);
       // verify(categoryMapper, times(1)).categoryDtotoCategory(categoryDto);
        verify(categoryRepository, times(1)).save(category);
        assertEquals("NEW_CAT", result.getCode());
        assertEquals("New Category", result.getDesignation());


    }

    @Test
    void testUpdateCategory() {

        Long id = 1L;
        CategoryDto categoryDto = CategoryDto.builder()
                .code("CAT002")
                .designation("Updated Category")
                .build();

        Category category = new Category();
        category.setId(id);

        when(categoryRepository.findById(id)).thenReturn(Optional.of(category));
        when(categoryRepository.save(category)).thenReturn(category);

        Category result = categoryService.updateCategory(id, categoryDto);

        assertNotNull(result);
        assertEquals("CAT002", result.getCode());
        assertEquals("Updated Category", result.getDesignation());
        verify(categoryRepository, times(1)).findById(id);
        verify(categoryRepository, times(1)).save(category);

    }

    @Test
    void testDeleteCategory() {
        Long id = 1L;
        Category category = new Category();
        category.setId(id);
        category.setCode("CAT001");
        category.setDesignation("Category to delete");
        categoryRepository.save(category);

        when(categoryRepository.findById(id)).thenReturn(Optional.of(category));
        when(categoryRepository.save(category)).thenReturn(category);
        when(categoryRepository.findByCode(category.getCode())).thenReturn(category);

        ResponseEntity<String> response = categoryService.deleteCategory(id);

        assertEquals("Catégorie supprimer avec succès", response.getBody());
        verify(categoryRepository, times(1)).findById(id);
        verify(categoryRepository, times(1)).deleteById(id);

        assertDoesNotThrow(() -> categoryService.deleteCategory(1L));
    }

}