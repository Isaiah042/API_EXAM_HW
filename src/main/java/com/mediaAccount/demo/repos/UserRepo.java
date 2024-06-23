package com.mediaAccount.demo.repos;

import com.mediaAccount.demo.pojos.Post;
import com.mediaAccount.demo.pojos.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User,Long> {
    List<User> findAllPostByUserId(Long userId);
}
