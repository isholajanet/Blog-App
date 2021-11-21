package com.BlogApp.Blog.controller;

import com.BlogApp.Blog.data.dto.ArticleDto;
import com.BlogApp.Blog.data.model.Article;
import com.BlogApp.Blog.data.model.Comment;
import com.BlogApp.Blog.services.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/article")
public class ArticleController{
    @Autowired
    private ArticleService articleService;

    @PostMapping("/save")
    public Article addPost(@RequestBody Article article){
        log.info("Running ->{}",article);
        return articleService.savePost(article);
    }
    @GetMapping("/article/{id}")
    public Article getArticle(@PathVariable Long id){
        return articleService.findById(id);
    }

    @DeleteMapping("/article/{id}")
    public void deleteArticle(@PathVariable Long id){
        articleService.delete(id);
    }
    @PatchMapping("/article/{id}")
    public ResponseEntity<?> updateArticle(@PathVariable Long id, @RequestBody ArticleDto articleDto){
        log.info("Request id --> {}", id);
        log.info("Product dto details --> {}", articleDto);
        Article article = null;
        try {
            article = articleService.updateArticle(id, articleDto);
        }catch(NullPointerException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
        return ResponseEntity.ok().body(article);
    }
    @GetMapping("/articles")
    public List<Article> findAll(){
        return articleService.findAll();
    }



}
