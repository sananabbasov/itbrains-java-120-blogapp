package az.edu.itbrains.controllers;


import az.edu.itbrains.dtos.CategoryDtos.CategoryAddDto;
import az.edu.itbrains.dtos.CategoryDtos.CategoryHomeDto;
import az.edu.itbrains.dtos.CategoryDtos.CategoryUpdateDto;
import az.edu.itbrains.services.CategoryService;
import az.edu.itbrains.services.impls.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/dashboard/category")
    public String dashboardCategory(Model model)
    {
        List<CategoryHomeDto> data = categoryService.getHomeCategories();
        model.addAttribute("categories",data);
        return "dashboard/category/index";
    }

    @GetMapping("/dashboard/category/add")
    public String createCategory()
    {
        return "dashboard/category/create";
    }

    @PostMapping("/dashboard/category/add")
    public String createCategory(CategoryAddDto categoryAddDto)
    {
        categoryService.createCategory(categoryAddDto);
        return "redirect:/dashboard/category";
    }


    @GetMapping("/dashboard/category/update/{id}")
    public String updateCategory(@PathVariable Long id, Model model)
    {
        CategoryUpdateDto category = categoryService.findUpdateCategory(id);
        model.addAttribute("category", category);
        return "/dashboard/category/update";
    }


    @PostMapping("/dashboard/category/update/{id}")
    public String updateCategory(@PathVariable Long id, CategoryUpdateDto categoryUpdate)
    {
        categoryService.updateCategory(categoryUpdate,id);
        return "redirect:/dashboard/category";

    }

    @GetMapping("/dashboard/category/delete/{id}")
    public String deleteCategory(@PathVariable Long id)
    {
        return "/dashboard/category/delete";
    }

    @PostMapping("/dashboard/category/delete/{id}")
    public String removeCategory(@PathVariable Long id)
    {
        categoryService.deleteCategory(id);
        return "redirect:/dashboard/category";
    }

}
