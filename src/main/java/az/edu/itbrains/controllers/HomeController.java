package az.edu.itbrains.controllers;

import az.edu.itbrains.dtos.ArticleDtos.ArticleHomeDto;
import az.edu.itbrains.dtos.ArticleDtos.ArticleTrendVideoDto;
import az.edu.itbrains.payload.ArticlePagination;
import az.edu.itbrains.services.ArticleService;
import az.edu.itbrains.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ArticleService articleService;

    @GetMapping("/")
    public String home(Model model,@RequestParam(value = "currentPage", required = false) Integer currentPage)
    {
        ArticlePagination articles = articleService.getHomePaginationArticle(currentPage);
        List<ArticleTrendVideoDto> trends = articleService.getTrendVideos();
        model.addAttribute("articles", articles.getArticles());
        model.addAttribute("trends", trends);
        model.addAttribute("pagination", articles.getPageSize());
        return "/Home";
    }

    @GetMapping("/contact")
    public String Contact()
    {
        return "Contact";
    }
}
