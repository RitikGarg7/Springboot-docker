package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get user by ID
    @Cacheable(value = "users", key = "#id")
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Create or update a user
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Delete a user
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
