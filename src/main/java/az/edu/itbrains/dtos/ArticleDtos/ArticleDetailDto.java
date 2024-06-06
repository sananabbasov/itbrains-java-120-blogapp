package az.edu.itbrains.dtos.ArticleDtos;

import az.edu.itbrains.dtos.CategoryDtos.CategoryHomeDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class ArticleDetailDto {
    private Long id;
    private String title;
    private String description;
    private String photoUrl;
    private int viewCount;
    private CategoryHomeDto category;
}
