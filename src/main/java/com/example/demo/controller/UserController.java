package com.example.demo.controller;

import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserService userService;
    private RoleService roleService;
}
