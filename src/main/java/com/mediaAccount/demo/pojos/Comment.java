package com.mediaAccount.demo.pojos;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    private String commentWords;

    private Long postId;

    private Long userId;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getCommentWords() {
        return commentWords;
    }

    public void setCommentWords(String commentWords) {
        this.commentWords = commentWords;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
