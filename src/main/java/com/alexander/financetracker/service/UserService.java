package com.alexander.financetracker.service;

import com.alexander.financetracker.exception.DuplicateEmailException;
import com.alexander.financetracker.model.User;
import com.alexander.financetracker.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new DuplicateEmailException("Email already in use");
        }
        return userRepository.save(user);
    }

    public User updateUser(Long id, User userDetails) {
        User user = getUserById(id);
        if (userDetails.getName() != null) user.setName(userDetails.getName());
        if (userDetails.getEmail() != null) user.setEmail(userDetails.getEmail());
        if (userDetails.getPassword() != null) user.setPassword(userDetails.getPassword());
        if (userDetails.getBudget() != null) user.setBudget(userDetails.getBudget());
        return userRepository.save(user);
    }

    public void deleteUser (Long id) {
        User user = getUserById(id);
        userRepository.delete(user);
    }
}
