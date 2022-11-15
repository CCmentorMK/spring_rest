package com.example.demo.service;

import com.example.demo.model.Role;

import java.util.Optional;

public interface RoleService {
    void addRole(String roleName);
    Optional<Role> findRoleByRoleName(String roleName);
}
