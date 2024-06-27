package az.edu.itbrains.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.userdetails.User;

@Data
@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;

    @ManyToOne
    private UserEntity user;



    @ManyToOne
    private Article article;
}
