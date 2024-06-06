package com.metrics.metric.controllers;

import com.metrics.metric.entities.User;
import com.metrics.metric.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private  final UserService userService;

    public  UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody User user) {
//        this.userService.createUser(user);
//        return ResponseEntity.ok().build();
        return new ResponseEntity<>(this.userService.createUser(user),HttpStatus.CREATED);
    }
}
