package com.BlogApp.Blog.services;

import com.BlogApp.Blog.data.dto.CommentDto;
import com.BlogApp.Blog.data.model.Article;
import com.BlogApp.Blog.data.model.Comment;
import com.BlogApp.Blog.data.repository.ArticleRepository;
import com.BlogApp.Blog.data.repository.CommentRepository;
import com.BlogApp.Blog.services.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ArticleService articleService;

    @Override
    public Comment add(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment findById(Long id) {
        Optional<Comment> comment = commentRepository.findById(id);
        return comment.orElse(null);
    }

    @Override
    public void delete(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public void delete(Comment comment) {
        commentRepository.delete(comment);
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Article addComment(Long articleId, CommentDto commentDto) {
        Article article = articleService.findById(articleId);
        if(article == null) throw new NoSuchElementException("Article does not exist");
        Comment comment = CommentMapper.mapCommentDtoToComment(commentDto);
        article.getComments().add(commentRepository.save(comment));
        articleService.savePost(article);
        return article;
    }
}
