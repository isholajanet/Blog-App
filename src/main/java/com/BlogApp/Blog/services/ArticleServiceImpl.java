package com.BlogApp.Blog.services;

import com.BlogApp.Blog.data.dto.ArticleDto;
import com.BlogApp.Blog.data.model.Article;
import com.BlogApp.Blog.data.model.User;
import com.BlogApp.Blog.data.repository.ArticleRepository;
import com.BlogApp.Blog.services.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    ArticleMapper articleMapper;


    @Override
    public Article savePost(Article article) {
        if(article == null){
            throw new NullPointerException("Article cannot be null");
        }
       return articleRepository.save(article);
    }

    @Override
    public Article findById(Long id) {
        Optional<Article>article =articleRepository.findById(id);
        if(article.isPresent()) {
            return article.get();
        }else{
            throw new IllegalArgumentException("It does not exist");
        }
    }

    @Override
    public void delete(Long id) {
        articleRepository.deleteById(id);
    }

    @Override
    public void delete(Article article) {
        articleRepository.delete(article);
    }

    @Override
    public Article updateArticle(Long id, ArticleDto update) {
        if(update == null){
            throw new IllegalArgumentException("Article Dto cannot be null");
        }
        Optional <Article> foundArticle = articleRepository.findById(id);
        if(foundArticle.isPresent()){
            Article articleToUpdate = foundArticle.get();
            articleMapper.mapArticleDtoToArticle(update, articleToUpdate);
            return articleRepository.save(articleToUpdate);

        }else{
            throw new IllegalArgumentException("Article with id " + id + " does not exist");
        }
    }

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }
}
