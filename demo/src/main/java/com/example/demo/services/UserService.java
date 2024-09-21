package com.example.demo.services;

import com.example.demo.model.user;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Find user by ID
    public Optional<user> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<user> getUserByDial(String dial) {
        return userRepository.findByDial(dial);
    }
    // Get all users
    public List<user> getAllUsers() {
        return userRepository.findAllUsers();
    }

    // Insert new user
    @Transactional
    public void createUser(Long id, Date DOI, Integer previousGiftsId, Integer giftId) {
        userRepository.insertUser(id, DOI, previousGiftsId, giftId);
    }

    // Update an existing user
    @Transactional
    public void updateUser(Long id, Date DOI, Integer previousGiftsId, Integer giftId) {
        userRepository.updateUser(id, DOI, previousGiftsId, giftId);
    }

    // Delete user by ID
    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteUser(id);
    }
}
