package com.example.demo.controllers;


import com.example.demo.entities.Comment;
import com.example.demo.request.CommentCreateRequest;
import com.example.demo.request.CommentUpdateRequest;
import com.example.demo.services.CommentService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
@CrossOrigin("*")

@RestController
@RequestMapping("/comments")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> getAllComments(@RequestParam Optional<Long> userId, @RequestParam Optional<Long> postId) {
return commentService.getAllCommentsWithParam(userId, postId);
    }
    @PostMapping
    public Comment createOneComment(@RequestBody CommentCreateRequest request) {
    	return commentService.createOneComment(request);
    }
    
    @GetMapping("/{commentId}")
    public Comment getOneComment(@PathVariable Long commentId) {
    	return commentService.getOneCommentById(commentId);
    }
    @PutMapping("/{commentId}")
    public Comment updateOneComment(@PathVariable Long commentId,@RequestBody CommentUpdateRequest request) {
    	return commentService.updateOneCommentById(commentId,request);
    }
    @DeleteMapping("/{commentId}")
    public void deleteOneCommentById(@PathVariable Long commentId) {
    	commentService.deleteOneCommentById(commentId);
    }
}
