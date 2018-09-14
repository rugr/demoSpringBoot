package com.example.demoSpringBoot.demoSpringBoot.controller;

import com.example.demoSpringBoot.demoSpringBoot.entity.User;
import com.example.demoSpringBoot.demoSpringBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by Ruslan on 29.08.2018.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(value = "/all")
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping(value = "/getById/{userId}")
    public User user(@PathVariable("userId") Long userId) {
        return userService.getById(userId);
    }

    @GetMapping(value = "/add/{login}/{name}")
    public User user(@PathVariable("login") String login, @PathVariable("name") String name) {
        User user = new User();
        user.setUsername(login);
        user.setUserPib(name);
        return userService.add(user);
    }

    @PostConstruct
    void init() {
        User user = new User();
        user.setId(1L);
        user.setUsername("admin");
        user.setPassword("1234");
        user.setUserPib("Admin Admin");
        userService.save(user);
        user.setId(2L);
        user.setUsername("user");
        user.setPassword("1234");
        user.setUserPib("User User");
        userService.save(user);
    }
}
