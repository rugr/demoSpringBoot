package com.example.demoSpringBoot.demoSpringBoot.service;

import com.example.demoSpringBoot.demoSpringBoot.dao.UserDao;
import com.example.demoSpringBoot.demoSpringBoot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ruslan on 29.08.2018.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User getById(Long id) {
        return userDao.findById(id).orElse(new User());
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public List<User> getAll() {
        return userDao.findAll();
    }

    @Override
    public User add(User user) {
        userDao.save(user);
        return user;
    }
}
