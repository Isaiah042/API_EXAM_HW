package com.mediaAccount.demo.services;

import com.mediaAccount.demo.exceptions.ResourceNotFound;
import com.mediaAccount.demo.pojos.Post;
import com.mediaAccount.demo.pojos.User;
import com.mediaAccount.demo.repos.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepo postRepo;

    public Post createPost(Post post){
        return postRepo.save(post);
    }

    public Post getPostById(Long postId){
        Post post = postRepo.findById(postId).orElse(null);
        if(post == null){
            throw new ResourceNotFound("Post not found");
        }
        return post;
    }

    public List<Post> getAllPost(){
        return postRepo.findAll();
    }

    public void deletePost(Long postId){
        Post post = postRepo.findById(postId).orElse(null);
        if(post == null){
            throw new ResourceNotFound("Cannot delete post by Id given: " + postId);
        }
        postRepo.deleteById(postId);
    }

    public Post updatePost(Long postId, Post updatedPost){
        Post post = postRepo.findById(postId).orElse(null);
        if(post == null){
            throw new ResourceNotFound("Cannot update post by Id given: " + postId);
        }
        post.setUserId(updatedPost.getUserId());
        post.setPostId(updatedPost.getPostId());
        post.setTitleOfPost(updatedPost.getTitleOfPost());
        post.setContentOfPost(updatedPost.getContentOfPost());
        return postRepo.save(post);

    }

    public List<Post> getPostByUserId(Long userId){
        return postRepo.findByUserId(userId);
    }

}
