package com.mediaAccount.demo.services;

import com.mediaAccount.demo.pojos.Comment;
import com.mediaAccount.demo.pojos.User;
import com.mediaAccount.demo.repos.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepo commentRepo;


    public ResponseEntity<?> createComment(Comment comment){
        return null;
    }

//    public User getUserById(Long userId){
//        return userRepo.findBy();
//    }

    public List<Comment> getAllComments(){
        return commentRepo.findAll();
    }

    public void deleteComment(Long commentId){

    }

    public Comment updateComment(Long commentId, Comment updatedComment){
        return null;
    }


}
