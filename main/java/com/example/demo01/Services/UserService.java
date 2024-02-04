package com.example.demo01.Services;

import com.example.demo01.Entities.User;
import com.example.demo01.Interfaces.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserInterface userRepository;

    @Autowired
    public UserService(UserInterface userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        Optional<User> optionalUser = userRepository.findByusername(username);
        return optionalUser.orElse(null);
    }

    public User findBystatus(String status) {
        Optional<User> optionalUser = userRepository.findBystatus(status);
        return optionalUser.orElse(null);
    }
    public User findByuserid(Long userid) {
        Optional<User> optionalUser = userRepository.findByuserid(userid);
        return optionalUser.orElse(null);
    }

    public boolean doesUserExist(Long id) {
        return userRepository.existsById(id);
    }

    public boolean isUsernameAvailable(String username) {
        Optional<User> optionalUser = userRepository.findByusername(username);
        return optionalUser.isEmpty();
    }


    }


