package com.mediaAccount.demo.repos;

import com.mediaAccount.demo.pojos.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post,Long> {

    //Have to write query if you dont want to use optional


}
