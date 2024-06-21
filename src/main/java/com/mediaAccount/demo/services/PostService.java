package com.mediaAccount.demo.services;

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

    public ResponseEntity<?> createPost(Post post){
        return null;
    }

//    public User getPostById(Long postId){
//        return userRepo.findBy();
//    }

    public List<Post> getAllPost(){
        return postRepo.findAll();
    }

    public void deletePost(Long postId){

    }

    public Post updatePost(Long postId, User updatedPost){
        return null;
    }

    public User getPostByUserId(){
        return null;
    }

}
