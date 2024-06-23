package com.mediaAccount.demo.pojos;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POST_ID")
    private Long postId;

    private String titleOfPost;

    private String contentOfPost;

    private Long userId;


    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getTitleOfPost() {
        return titleOfPost;
    }

    public void setTitleOfPost(String titleOfPost) {
        this.titleOfPost = titleOfPost;
    }


    public String getContentOfPost() {
        return contentOfPost;
    }

    public void setContentOfPost(String contentOfPost) {
        this.contentOfPost = contentOfPost;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
