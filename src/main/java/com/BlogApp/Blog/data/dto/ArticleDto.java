package com.BlogApp.Blog.data.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ArticleDto {
    private String title;
    private String description;
    private String imageUrl;
    private LocalDate dateUpdated;
}
