package com.mediaAccount.demo.repos;

import com.mediaAccount.demo.pojos.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post,Long> {
    List<Post> findByUserId(Long userId);


}
