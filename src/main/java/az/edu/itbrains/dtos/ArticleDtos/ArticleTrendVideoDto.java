package az.edu.itbrains.dtos.ArticleDtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleTrendVideoDto {
    private Long id;
    private String title;
    private String photoUrl;
}
