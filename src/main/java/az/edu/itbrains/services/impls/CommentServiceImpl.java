package az.edu.itbrains.services.impls;

import az.edu.itbrains.dtos.CommentDtos.CommentCreateDto;
import az.edu.itbrains.dtos.CommentDtos.CommentDto;
import az.edu.itbrains.models.Article;
import az.edu.itbrains.models.Category;
import az.edu.itbrains.models.Comment;
import az.edu.itbrains.models.UserEntity;
import az.edu.itbrains.repositories.CommentRepository;
import az.edu.itbrains.services.ArticleService;
import az.edu.itbrains.services.CommentService;
import az.edu.itbrains.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ArticleService articleService;


    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void addComment(CommentCreateDto commentCreate, String email) {
        UserEntity user = userService.findByEmail(email);
        Comment newComment = modelMapper.map(commentCreate, Comment.class);
        newComment.setUser(user);
        commentRepository.save(newComment);
    }

    @Override
    public List<CommentDto> getCommentsByArticleId(Long articleId) {
        List<Comment> result = commentRepository.findByArticleId(articleId);
        List<CommentDto> comments = result.stream().map(c ->{
            CommentDto comment = modelMapper.map(c, CommentDto.class);
            comment.setFullName(c.getUser().getFirstName() + " " + c.getUser().getLastName());
            return comment;
        }).collect(Collectors.toList());

        return comments;
    }
}
