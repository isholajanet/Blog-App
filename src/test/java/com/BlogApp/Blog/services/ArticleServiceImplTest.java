package com.BlogApp.Blog.services;

import com.BlogApp.Blog.data.dto.ArticleDto;
import com.BlogApp.Blog.data.model.Article;
import com.BlogApp.Blog.data.repository.ArticleRepository;
import com.BlogApp.Blog.services.mapper.ArticleMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest
@Slf4j
class ArticleServiceImplTest {

    @Mock
    ArticleRepository articleRepository;
    @Mock
    ArticleMapper articleMapperImpl;
    @InjectMocks
    ArticleServiceImpl articleService;


    @BeforeEach
    void setUp(){
        articleService = new ArticleServiceImpl();
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void saveArticle(){
       Article article = new Article();
       when(articleService.savePost(article)).thenReturn(article);
       articleService.savePost(article);
       verify(articleRepository, times(1)).save(article);
    }


    @Test
    void findArticleById(){
        Article article = new Article();
        article.setId(1L);
        when(articleService.savePost(article)).thenReturn(article);
        articleService.savePost(article);
        verify(articleRepository, times(1)).save(article);
//        when(articleService.findById(1L)).thenReturn(Optional.of(article));
        articleService.findById(1L);
        verify(articleRepository, times(1)).findById(1L);
    }
    @Test
    void deleteArticleById(){
        Article article = new Article();
        article.setId(1L);
        when(articleService.savePost(article)).thenReturn(article);
        articleService.savePost(article);
        verify(articleRepository, times(1)).save(article);

//        when(articleService.findById(1L)).thenReturn(Optional.of(article));
        articleService.findById(1L);
        verify(articleRepository, times(1)).findById(1L);
        articleRepository.deleteById(1L);
        when(articleService.findById(1L)).thenReturn(null);
    }


    @Test
    void deleteArticle(){
        Article article = new Article();
        article.setId(1L);
        when(articleService.savePost(article)).thenReturn(article);

//        when(articleService.findById(1L)).thenReturn(Optional.of(article));
        articleService.findById(1L);

        articleService.delete(article);
        when(articleService.findById(1L)).thenReturn(null);
        verify(articleRepository, times(1)).delete(article);
    }
    @Test
    void updateArticle(){
        Article article = new Article();
        article.setId(1L);
        article.setTitle("Introduction to java");
        article.setDescription("Java is a programming language");
        article.setImageUrl("https://www.image.org");

        when(articleService.savePost(article)).thenReturn(article);

        ArticleDto articleDto = new ArticleDto();
        articleDto.setTitle("Me and you");
        articleDto.setDescription("You br movie");

        when(articleMapperImpl.mapArticleDtoToArticle(articleDto,article)).then((e)->{
            article.setTitle(articleDto.getTitle());
            article.setDescription(articleDto.getDescription());
            return null;
        });
//        when(articleService.findById(1L)).thenReturn(Optional.of(article));
//        when(articleService.updateArticle(1L, articleDto)).thenReturn(article);
            articleService.updateArticle(1L,articleDto);
        verify(articleRepository, times(1)).save(article);
        verify(articleRepository,times(1)).findById(1L);
    }
}