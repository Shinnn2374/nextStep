package com.example.user_service.service;

import com.example.user_service.dao.UserRepository;
import com.example.user_service.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("bla bla"));
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public User updateUserById(Long id, User user) {
        User updateUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("bla bla"));
        updateUser.setUsername(user.getUsername());
        updateUser.setEmail(user.getEmail());
        return userRepository.save(updateUser);
    }

    public Void  deleteById(Long id) {
        userRepository.deleteById(id);
        return null;
    }
}
