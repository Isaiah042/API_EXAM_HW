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


    public Comment createComment(Comment comment){
        return commentRepo.save(comment);
    }

    public Comment createComment(Comment comment,Long postId){
        comment.setPostId(postId);
        return commentRepo.save(comment);
    }

    public Comment getCommentById(Long commentId){
        Comment comment = commentRepo.findById(commentId).orElse(null);
        if (comment == null){
            throw new RuntimeException("Comment not found");
        }
        return comment;
    }

    public List<Comment> getAllComments(){
        return commentRepo.findAll();
    }

    public void deleteComment(Long commentId){
        Comment comment = commentRepo.findById(commentId).orElse(null);
        if (comment == null){
            throw new RuntimeException("Comment not found");
        }
        commentRepo.deleteById(commentId);
    }

    public Comment updateComment(Long commentId, Comment updatedComment){
        Comment comment = commentRepo.findById(commentId).orElse(null);
        if (comment == null){
            throw new RuntimeException("Comment not found");
        }
        comment.setUserId(updatedComment.getUserId());
        comment.setPostId(updatedComment.getPostId());
        comment.setCommentId(updatedComment.getCommentId());
        comment.setCommentWords(updatedComment.getCommentWords());
        return commentRepo.save(comment);
    }

    public List<Comment> getCommentsByPostId(Long postId){
        return commentRepo.findCommentByPostId(postId);
    }


}
