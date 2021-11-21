package com.BlogApp.Blog.services.mapper;

import com.BlogApp.Blog.data.dto.CommentDto;
import com.BlogApp.Blog.data.model.Comment;

public class CommentMapper {


    public static Comment mapCommentDtoToComment(CommentDto commentDto){
        Comment comment = new Comment();
        comment.setName(commentDto.getName());
        comment.setText(commentDto.getText());
        return comment;
    }
}
