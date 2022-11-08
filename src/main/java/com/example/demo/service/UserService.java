package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.model.enums.RoleName;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserService {
    User addUser(String email, String password);
    Optional<User> findUserById(long userId);
    Set<Role> getUserRoles(long userId);
    void addUserRoleByRoleName(long userId, RoleName roleName);
}
