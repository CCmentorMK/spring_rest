package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User addUser(String email, String password){
        return userRepository.save(new User(email, password));
    }

    @Override
    public void grantRoleToUser(long userId, Role role) {

    }
    @Override
    public Optional<User> findUserById(long userId){
        return userRepository.findById(userId);
    }

}
