package com.mediaAccount.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mediaAccount.demo.pojos.Comment;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment,Long> {

    //Have to write query if you dont want to use optional

}
