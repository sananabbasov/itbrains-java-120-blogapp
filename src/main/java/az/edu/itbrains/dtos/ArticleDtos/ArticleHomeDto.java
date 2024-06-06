package az.edu.itbrains.dtos.ArticleDtos;


import az.edu.itbrains.dtos.CategoryDtos.CategoryHomeDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleHomeDto {
    private Long id;
    private String title;
    private String description;
    private String photoUrl;
    private int viewCount;
    private CategoryHomeDto category;
}
