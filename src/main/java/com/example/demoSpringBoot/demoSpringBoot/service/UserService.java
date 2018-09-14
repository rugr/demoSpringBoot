package com.example.demoSpringBoot.demoSpringBoot.service;

import com.example.demoSpringBoot.demoSpringBoot.entity.User;

import java.util.List;

/**
 * Created by Ruslan on 29.08.2018.
 */
public interface UserService {
    User getById(Long id);
    void  save(User user);
    List<User> getAll();
    User add(User user);
}
