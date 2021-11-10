package com.BlogApp.Blog.services;

import com.BlogApp.Blog.data.dto.ArticleDto;
import com.BlogApp.Blog.data.model.Article;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ArticleService {
    Article savePost(Article article);
    Article findById(Long id);
    void delete(Long id);
    void delete(Article article);
    Article updateArticle(Long id, ArticleDto article);
    List<Article> findAll();

}
