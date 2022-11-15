package com.example.demo.controller;

import com.example.demo.model.Role;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {
    private UserService userService;
    private RoleService roleService;

    @Autowired
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostMapping("/user")
    public void addUserWithUserRole(
            @RequestParam("email") String email,
            @RequestParam("password") String password
    ){
        // szukamy domyślnej roli USER -> po nazwie
        Optional<Role> roleOptional = roleService.findRoleByRoleName("user");
        // przekazujemy rolę do nowo tworoznego użytkownika
        userService.addUser(email, password, roleOptional);
    }
}
