package com.mediaAccount.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mediaAccount.demo.pojos.Comment;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment,Long> {
    List<Comment> findCommentByPostId(Long postId);
}
