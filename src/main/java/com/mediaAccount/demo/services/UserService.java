package com.mediaAccount.demo.services;

import com.mediaAccount.demo.pojos.Post;
import com.mediaAccount.demo.pojos.User;
import com.mediaAccount.demo.repos.PostRepo;
import com.mediaAccount.demo.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PostRepo postRepo;

    public ResponseEntity<?> createAnAccount(User user){
        return null;
    }

//    public User getUserById(Long userId){
//        return userRepo.findBy();
//    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public void deleteUser(Long userId){

    }

    public User updateUser(Long userId, User updatedUser){
        return null;
    }


}
