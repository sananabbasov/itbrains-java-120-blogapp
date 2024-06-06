package az.edu.itbrains.dtos.ArticleDtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleUpdateDto {
    private String title;
    private String description;
    private String photoUrl;
    private Long categoryId;
}
