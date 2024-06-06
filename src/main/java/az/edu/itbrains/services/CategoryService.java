package az.edu.itbrains.services;

import az.edu.itbrains.dtos.CategoryDtos.CategoryAddDto;
import az.edu.itbrains.dtos.CategoryDtos.CategoryHomeDto;
import az.edu.itbrains.dtos.CategoryDtos.CategoryUpdateDto;
import az.edu.itbrains.models.Category;

import java.util.List;

public interface CategoryService {
    void createCategory(CategoryAddDto categoryAddDto);
    List<CategoryHomeDto> getHomeCategories();
    void updateCategory(CategoryUpdateDto categoryUpdateDto, Long id);
    CategoryUpdateDto findUpdateCategory(Long id);

    void deleteCategory(Long id);

    Category findCategoryById(Long id);
}
