package az.edu.itbrains.services;

import az.edu.itbrains.dtos.ArticleDtos.ArticleCreateDto;
import az.edu.itbrains.dtos.ArticleDtos.ArticleDashboardDto;
import az.edu.itbrains.dtos.ArticleDtos.ArticleUpdateDto;

import java.util.List;

public interface ArticleService {

    void createArticle(ArticleCreateDto articleCreateDto);

    List<ArticleDashboardDto> getDashboardArticles();

    ArticleUpdateDto getUpdateArticles(Long id);

    void updateArticle(ArticleUpdateDto articleUpdateDto, Long id);
    void removeArticle(Long id);
}
