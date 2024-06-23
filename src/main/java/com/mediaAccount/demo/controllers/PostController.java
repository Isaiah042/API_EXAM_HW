package com.mediaAccount.demo.controllers;

import com.mediaAccount.demo.pojos.Post;
import com.mediaAccount.demo.pojos.User;
import com.mediaAccount.demo.services.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {

    private static final Logger logger = LoggerFactory.getLogger(PostController.class);

    @Autowired
    private PostService postService;

    @PostMapping("/user/{userId}/post")
    public ResponseEntity<?> createPost(@RequestBody Post post) {
        Post postCreated = postService.createPost(post);
        logger.info("Post created successfully");
        return new ResponseEntity<>(postCreated, HttpStatus.OK);
    }

    @GetMapping("/user/post/{postId}")
    public ResponseEntity<Post> getPostById(@PathVariable Long postId) {
        Post post = postService.getPostById(postId);
        logger.info("Post with id {}", post + " retrieved successfully");
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @GetMapping("/posts")
    public ResponseEntity<?> getAllPost() {
        Iterable<Post> post = postService.getAllPost();
        logger.info("Post retrieved successfully");
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<?> getPostByUserId(@PathVariable Long userId) {
        Iterable<Post> post = postService.getPostByUserId(userId);
        logger.info("Post retrieved successfully");
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @DeleteMapping("/post/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
        logger.info("Post deleted successfully");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/users/post/{postId}")
    public ResponseEntity<Post> updatePost(@PathVariable Long postId,@RequestBody Post updatedPost) {
        postService.updatePost(postId, updatedPost);
        logger.info("Post updated successfully");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
