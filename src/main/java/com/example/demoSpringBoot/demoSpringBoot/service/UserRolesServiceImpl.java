package com.example.demoSpringBoot.demoSpringBoot.service;

import com.example.demoSpringBoot.demoSpringBoot.entity.Role;
import com.example.demoSpringBoot.demoSpringBoot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ruslan on 29.08.2018.
 */
@Service
public class UserRolesServiceImpl implements UserRolesService {
    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Override
    public void add(Long userId, Long roleId) {
        User user = userService.getById(userId);
        Role role = roleService.getById(roleId);
        Set<Role> userRoles = user.getRoles();
        if(userRoles == null) {
            userRoles = new HashSet<>();
        }
        userRoles.add(role);
        user.setRoles(userRoles);
        userService.save(user);
    }

    @Override
    public void remove(Long userId, Long roleId) {
        User user = userService.getById(userId);
        Set<Role> userRoles = user.getRoles();
        if(userRoles == null) {
            return;
        }
        userRoles.remove(roleService.getById(roleId));
        user.setRoles(userRoles);
        userService.save(user);
    }
}
