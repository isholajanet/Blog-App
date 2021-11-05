package com.BlogApp.Blog.services;

import com.BlogApp.Blog.data.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Slf4j
class ArticleServiceImplTest {

    @Autowired
    ArticleServiceImpl articleService;


    @Test
    void saveArticle(){
        Article article = Article.builder().title("Article")
                .description("My article").imageUrl("https://myImage.com").build();
        assertThat(article.getId()).isNull();
        articleService.savePost(article);
        assertThat(article.getId()).isNotNull();

    }
}