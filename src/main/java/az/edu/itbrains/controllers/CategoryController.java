package az.edu.itbrains.controllers;


import az.edu.itbrains.services.CategoryService;
import az.edu.itbrains.services.impls.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryController {

    @Autowired
    CategoryService categoryService;


    @GetMapping("/dashboard/category")
    public String dashboardCategory()
    {
        categoryService.createCategory(null);
        return "";
    }
}
