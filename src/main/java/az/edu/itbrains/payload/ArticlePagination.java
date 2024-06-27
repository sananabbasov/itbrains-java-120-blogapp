package az.edu.itbrains.payload;

import az.edu.itbrains.dtos.ArticleDtos.ArticleHomeDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticlePagination {
    private List<ArticleHomeDto> articles;
    private Long pageSize;
}
