package com.BlogApp.Blog.controller;

import com.BlogApp.Blog.data.dto.CommentDto;
import com.BlogApp.Blog.data.model.Article;
import com.BlogApp.Blog.data.model.Comment;
import com.BlogApp.Blog.services.ArticleService;
import com.BlogApp.Blog.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

//
    @PostMapping("/add")
    public Comment save(@RequestBody Comment comment){
        return commentService.add(comment);
    }

    @GetMapping("/{id}")
    public Comment findById(@PathVariable Long id){
        return commentService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        commentService.delete(id);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Comment comment){
        commentService.delete(comment);
    }


    @PatchMapping("/{id}")
    public ResponseEntity<?> addComment(@PathVariable Long id, @RequestBody CommentDto commentDto  ){
       Article returned = commentService.addComment(id, commentDto);
        return new ResponseEntity<>(returned, HttpStatus.OK);
    }

}
