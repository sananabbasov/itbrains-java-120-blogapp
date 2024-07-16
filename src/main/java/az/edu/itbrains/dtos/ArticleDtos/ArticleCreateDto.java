package az.edu.itbrains.dtos.ArticleDtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ArticleCreateDto {
    @NotBlank(message = "Name is mandatory")
    private String title;
    private String description;
    private String photoUrl;
    private Long categoryId;
}
