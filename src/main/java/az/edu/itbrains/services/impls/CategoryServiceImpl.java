package az.edu.itbrains.services.impls;

import az.edu.itbrains.dtos.CategoryDtos.CategoryAddDto;
import az.edu.itbrains.dtos.CategoryDtos.CategoryHomeDto;
import az.edu.itbrains.models.Category;
import az.edu.itbrains.repositories.ArticleRepository;
import az.edu.itbrains.repositories.CategoryRepository;
import az.edu.itbrains.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void createCategory(CategoryAddDto categoryAddDto) {

        Category category = new Category();
        category.setName(categoryAddDto.getName());
        categoryRepository.save(category);
    }

    @Override
    public List<CategoryHomeDto> getHomeCategories() {
        List<CategoryHomeDto> categories = categoryRepository.findAll()
                .stream()
                .map(category-> modelMapper.map(category, CategoryHomeDto.class))
                .toList();

        return categories;
    }
}