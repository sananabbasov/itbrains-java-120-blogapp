package az.edu.itbrains.services;

import az.edu.itbrains.dtos.CategoryDtos.CategoryAddDto;
import az.edu.itbrains.dtos.CategoryDtos.CategoryHomeDto;

import java.util.List;

public interface CategoryService {
    void createCategory(CategoryAddDto categoryAddDto);
    List<CategoryHomeDto> getHomeCategories();
}
