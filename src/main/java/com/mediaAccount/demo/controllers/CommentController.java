package com.mediaAccount.demo.controllers;

import com.mediaAccount.demo.pojos.Comment;
import com.mediaAccount.demo.pojos.Post;
import com.mediaAccount.demo.services.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {

    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);

    @Autowired
    private CommentService commentService;

//    @PostMapping("/user/post/comment")
//    public ResponseEntity<?> createComment(@RequestBody Comment comment) {
//        Comment commentCreated = commentService.createComment(comment);
//        logger.info("Comment created successfully");
//        return new ResponseEntity<>(commentCreated, HttpStatus.OK);
//    }

    @PostMapping("/user/post/{id}/comment")
    public ResponseEntity<?> createComment(@RequestBody Comment comment,@PathVariable Long postId) {
       Comment commentCreated = commentService.createComment(comment,postId);
        logger.info("Comment created successfully");
        return new ResponseEntity<>(commentCreated, HttpStatus.OK);
    }

    @PostMapping("/user/post/comment/{id}")
    public ResponseEntity<?> getCommentById(@PathVariable Long commentId) {
        Comment comment = commentService.getCommentById(commentId);
        logger.info("Comment with id {} retrieved successfully", commentId);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @GetMapping("/user/post/comments")
    public ResponseEntity<?> getAllComments() {
        Iterable<Comment> comments = commentService.getAllComments();
        logger.info("Comments retrieved successfully");
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }


    @DeleteMapping("/user/post/comment/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        logger.info("Comment deleted successfully");
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PutMapping("/user/post/comment/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long commentId,@RequestBody Comment updatedComment) {
        commentService.updateComment(commentId, updatedComment);
        logger.info("Comment updated successfully");
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
