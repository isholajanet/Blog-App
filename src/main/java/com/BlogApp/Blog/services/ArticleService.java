package com.BlogApp.Blog.services;

import com.BlogApp.Blog.data.dto.ArticleDto;
import com.BlogApp.Blog.data.model.Article;
import org.springframework.stereotype.Service;

@Service
public interface PostService {
    void savePost(Article article);
    Article findById(Long id);
    void delete(Long id);
    void delete(Article article);
    Article updateArticle(ArticleDto article);


}
