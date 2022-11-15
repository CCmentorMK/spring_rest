package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
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
    public User addUser(String email, String password, Optional<Role> role){
        // dodajemy domyślnie rolę user
        User user = new User(email, password);
        user.setRoles(new HashSet<>(Arrays.asList(role.orElse(new Role()))));
        return userRepository.save(user);
    }

    @Override
    public void grantRoleToUser(long userId, Role role) {

    }
    @Override
    public Optional<User> findUserById(long userId){
        return userRepository.findById(userId);
    }

}
