package az.edu.itbrains.services;

import az.edu.itbrains.dtos.ArticleDtos.*;
import az.edu.itbrains.models.Article;
import az.edu.itbrains.payload.ArticlePagination;

import java.util.List;

public interface ArticleService {

    void createArticle(ArticleCreateDto articleCreateDto);

    List<ArticleDashboardDto> getDashboardArticles();

    ArticleUpdateDto getUpdateArticles(Long id);

    void updateArticle(ArticleUpdateDto articleUpdateDto, Long id);
    void removeArticle(Long id);
    List<ArticleHomeDto> getHomeArticle();
    ArticleDetailDto getDetail(Long id);
    Article get(Long id);

    ArticlePagination getHomePaginationArticle(Integer currentPage);

    List<ArticleTrendVideoDto> getTrendVideos();
    List<ArticleRelatedDto> getRelatedArticles(Long categoryId);
}
