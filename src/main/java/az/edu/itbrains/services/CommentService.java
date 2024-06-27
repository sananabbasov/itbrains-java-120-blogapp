package az.edu.itbrains.services;

import az.edu.itbrains.dtos.CommentDtos.CommentCreateDto;
import az.edu.itbrains.dtos.CommentDtos.CommentDto;

import java.util.List;

public interface CommentService {

    void addComment(CommentCreateDto commentCreate,String email);
    List<CommentDto> getCommentsByArticleId(Long articleId);
}
