package az.edu.itbrains.controllers;


import az.edu.itbrains.dtos.CategoryDtos.CategoryAddDto;
import az.edu.itbrains.dtos.CategoryDtos.CategoryHomeDto;
import az.edu.itbrains.services.CategoryService;
import az.edu.itbrains.services.impls.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/admin/category")
    public String dashboardCategory(Model model)
    {
        List<CategoryHomeDto> data = categoryService.getHomeCategories();
        model.addAttribute("categories",data);
        return "admin/category/index";
    }

    @GetMapping("/admin/category/add")
    public String createCategory()
    {
        return "admin/category/create";
    }

    @PostMapping("/admin/category/add")
    public String createCategory(CategoryAddDto categoryAddDto)
    {
        categoryService.createCategory(categoryAddDto);
        return "redirect:/admin/category";
    }
}
