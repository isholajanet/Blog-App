package com.BlogApp.Blog.data.repository;

import com.BlogApp.Blog.data.model.Article;
import com.BlogApp.Blog.data.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class ArticleRepositoryTest {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    void articleCanBeCreated(){
        User user = User.builder().username("tomi").password("tomi12").build();
        userRepository.save(user);
        Article article = Article.builder().title("My first blog")
                .description("This is my first blog").user(user).build();
        log.info("Before saving ->{}", article);
        assertThat(article.getId()).isNull();
        articleRepository.save(article);
        assertThat(article.getId()).isNotNull();
        assertThat(article.getUser()).isNotNull();
        assertThat(article.getUser().getUsername()).isNotNull();
        assertThat(article.getUser().getUsername()).isEqualTo("tomi");
        log.info("After saving -> {}", article);
    }

}