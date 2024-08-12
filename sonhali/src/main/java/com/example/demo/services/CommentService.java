package com.example.demo.services;


import com.example.demo.entities.Comment;
import com.example.demo.repos.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    private CommentRepository commentRepository;
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> getAllCommentsWithParam(Optional<Long> userId, Optional<Long> postId) {
        if(userId.isPresent() && postId.isPresent()){
            return commentRepository.findByUserIdAndPostId(userId.get(),postId.get());

        } else if (userId.isPresent()) {
            return commentRepository.findByUserId(userId);
            
        } else if (postId.isPresent()) {
            return  commentRepository.findByPostId(postId.get());
        }
        return null;
    }
}
