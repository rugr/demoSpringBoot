package com.example.demoSpringBoot.demoSpringBoot.controller;

import com.example.demoSpringBoot.demoSpringBoot.entity.Role;
import com.example.demoSpringBoot.demoSpringBoot.service.UserRolesService;
import com.example.demoSpringBoot.demoSpringBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * Created by Ruslan on 29.08.2018.
 */
@RestController
public class UserRolesController {
    @Autowired
    UserService userService;

    @Autowired
    UserRolesService userRolesService;

    @GetMapping(value = "get/user/roles/{userId}")
    public Set<Role> getUserRoles(@PathVariable("userId") Long userId) {
        return userService.getById(userId).getRoles();
    }

    @GetMapping(value = "add/user/role/{userId}/{roleId}")
    public Set<Role> userAddRole(@PathVariable("userId") Long userId, @PathVariable("roleId") Long roleId) {
        userRolesService.add(userId, roleId);
        return userService.getById(userId).getRoles();
    }

    @GetMapping(value = "remove/user/role/{userId}/{roleId}")
    public Set<Role> userRemoveRole(@PathVariable("userId") Long userId, @PathVariable("roleId") Long roleId) {
        userRolesService.remove(userId, roleId);
        return userService.getById(userId).getRoles();
    }

}
