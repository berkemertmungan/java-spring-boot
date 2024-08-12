package com.example.demo.services;

import com.example.demo.entities.Post;
import com.example.demo.entities.User;
import com.example.demo.repos.PostRepository;
import com.example.demo.requests.PostCreateRequest;
import com.example.demo.requests.PostUpdateRequest;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class PostService {
    private PostRepository postRepository;
    private UserService  userService;
    private PostCreateRequest newPostRequest;
    private PostUpdateRequest updatePost;


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
        toSave.setId(newPostRequest.getId());
        toSave.setText(newPostRequest.getText());
        toSave.setTitle(newPostRequest.getTitle());
        toSave.setUser(user);
        return postRepository.save(toSave);

    }


    public Post updateOnePostById(Long postId) {
Optional<Post> post = postRepository.findById(postId);
if(post.isPresent()) {
    Post ToUpdate = post.get();
    ToUpdate.setText(updatePost.getText());
    ToUpdate.setTitle(updatePost.getTitle());
    postRepository.save(ToUpdate);
    return ToUpdate;
}
return null;
    }

    public void deleteOnePostById(Long postId) {
        postRepository.deleteById(postId);
    }
}
