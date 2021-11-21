package com.BlogApp.Blog.services;

import com.BlogApp.Blog.data.dto.CommentDto;
import com.BlogApp.Blog.data.model.Article;
import com.BlogApp.Blog.data.model.Comment;

import java.util.List;

public interface CommentService {

    Comment add(Comment comment);
    Comment findById(Long id);
    void delete(Long id);
    void delete(Comment comment);
    List<Comment> findAll();
    Article addComment(Long id, CommentDto commentDto);
}
