package com.BlogApp.Blog.services;

import com.BlogApp.Blog.data.dto.ArticleDto;
import com.BlogApp.Blog.data.model.Article;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService{
    @Override
    public void savePost(Article article) {

    }

    @Override
    public Article findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void delete(Article article) {

    }

    @Override
    public Article updateArticle(ArticleDto article) {
        return null;
    }
}
