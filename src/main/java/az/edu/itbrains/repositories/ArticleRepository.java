package az.edu.itbrains.repositories;

import az.edu.itbrains.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
