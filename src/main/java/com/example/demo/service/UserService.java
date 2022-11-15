package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.model.User;

import java.util.Optional;
import java.util.Set;

public interface UserService {
    User addUser(String email, String password, Optional<Role> role);
    void grantRoleToUser(long userId, Role role);
    Optional<User> findUserById(long userId);

}
