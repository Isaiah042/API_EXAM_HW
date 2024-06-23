package com.mediaAccount.demo.controllers;

import com.mediaAccount.demo.pojos.User;
import com.mediaAccount.demo.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        User userCreated = userService.createAnAccount(user);
        logger.info("User created successfully");
        return new ResponseEntity<>(userCreated, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@RequestBody Long userId) {
        User user = userService.getUserById(userId);
        logger.info("User with id {}", user + " retrieved successfully");
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
        Iterable<User> users = userService.getAllUsers();
        logger.info("Users retrieved successfully");
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@RequestBody Long userId) {
        userService.deleteUser(userId);
        logger.info("User deleted successfully");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId,@RequestBody User updatedUser) {
        userService.updateUser(userId, updatedUser);
        logger.info("User updated successfully");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
