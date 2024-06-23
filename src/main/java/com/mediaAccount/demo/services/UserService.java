package com.mediaAccount.demo.services;

import com.mediaAccount.demo.exceptions.ResourceNotFound;
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


    public User createAnAccount(User user){
        return userRepo.save(user);
    }

    public User getUserById(Long userId){
        User user = userRepo.findById(userId).orElse(null);
        if (user == null){
            throw new ResourceNotFound("User not found");
        }
        return user;
    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public void deleteUser(Long userId){
        User user = userRepo.findById(userId).orElse(null);
        if (user == null){
            throw new ResourceNotFound("Cannot delete user with id " + userId);
        }
        userRepo.deleteById(userId);
    }

    public User updateUser(Long userId, User updatedUser){
        User user = userRepo.findById(userId).orElse(null);
        if (user == null){
            throw new ResourceNotFound("Incorrect user id to update an existing one");
        }
        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        user.setGender(updatedUser.getGender());
        user.setUserName(updatedUser.getUserName());

        return userRepo.save(updatedUser);
    }


}
