package com.example.demo.job;

import com.example.demo.model.User;
import org.springframework.batch.item.ItemProcessor;

public class UserItemProcessor implements ItemProcessor<User, User> {
    @Override
    public User process(User user) {
        user.setName(user.getName().toUpperCase()); // Example: Convert name to uppercase
        return user;
    }
}
