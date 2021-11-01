package com.BlogApp.Blog.data.repository;

import com.BlogApp.Blog.data.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}
