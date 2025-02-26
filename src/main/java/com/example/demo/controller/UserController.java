package com.example.demo.controller;

import com.example.demo.logging.AuditLogProducer;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuditLogProducer auditLogProducer;

    // Get all users
    @GetMapping
    public List<User> getAllUsers() {
        List<User> users = userService.getAllUsers();
        auditLogProducer.logUserAction("Fetched All Users", "system"); // Log action
        return users;
    }

    // Get user by ID
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        auditLogProducer.logUserAction("Fetched User", id.toString()); // Log action
        return user;
    }

    // Create a new user
    @PostMapping
    public User createUser(@RequestBody User user) {
        User createdUser = userService.saveUser(user);
        auditLogProducer.logUserAction("User Created", createdUser.getId().toString());
        return createdUser;
    }

    // Update an existing user
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        User updatedUser = userService.saveUser(user);
        auditLogProducer.logUserAction("User Updated", updatedUser.getId().toString());
        return updatedUser;
    }

    // Delete a user
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        auditLogProducer.logUserAction("User Deleted", id.toString());
    }
}
