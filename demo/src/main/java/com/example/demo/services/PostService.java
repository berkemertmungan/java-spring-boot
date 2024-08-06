package com.example.demo.services;

import com.example.demo.entities.Post;
import com.example.demo.entities.User;
import com.example.demo.repos.PostRepository;
import com.example.demo.requests.PostCreateRequest;

import java.awt.*;
import java.util.List;
import java.util.Optional;

public class PostService {
    private PostRepository postRepository;
    private UserService  userService;
    private Label newPostRequest;


    public PostService(PostRepository postRepository,UserService  userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    public List<Post> getAllPosts(Optional<Long> userId) {
        if (userId.isPresent()) {
            return postRepository.findByUserId(userId.get());
        }
        return postRepository.findAll();
    }



    public Post getOnePostById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }

    public Post createOnePost(PostCreateRequest newPost) {
        User user = UserService.getOneUser(newPostRequest.getUserId());
        if(user == null) {
            return null;
        }
        Post toSave = new Post();
        toSave.setUser(user);
        toSave.setId(newPostRequset.getId());
        toSave.setText(newPostRequest.getText());
        toSave.setTitle(newPostRequest.getTitle());

        return PostRepository.save(newPost);
    }
}
