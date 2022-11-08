package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.model.enums.RoleName;

import java.util.Optional;

public interface RoleService {
    Optional<Role> getRoleByRoleName(RoleName roleName);
}
