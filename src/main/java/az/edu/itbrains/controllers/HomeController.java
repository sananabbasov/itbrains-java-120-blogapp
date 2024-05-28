package az.edu.itbrains.controllers;


import az.edu.itbrains.dtos.CategoryDtos.CategoryAddDto;
import az.edu.itbrains.models.Category;
import az.edu.itbrains.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public String Index()
    {
        return "Home";
    }

    @GetMapping("/contact")
    public String Contact()
    {
        return "Contact";
    }
}
