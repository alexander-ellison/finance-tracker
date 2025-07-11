package com.alexander.financetracker.service;

import com.alexander.financetracker.model.User;
import com.alexander.financetracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Additional methods (e.g., getUserById, updateUser, deleteUser) to be added here
}
