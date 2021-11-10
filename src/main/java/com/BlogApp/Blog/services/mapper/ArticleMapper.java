package com.BlogApp.Blog.services.mapper;

import com.BlogApp.Blog.data.dto.ArticleDto;
import com.BlogApp.Blog.data.model.Article;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface ArticleMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)

    Article mapArticleDtoToArticle(ArticleDto articleDto, @MappingTarget Article article);

}
