package com.example.demoSpringBoot.demoSpringBoot.service;

/**
 * Created by Ruslan on 29.08.2018.
 */
public interface UserRolesService {
    void add(Long userId, Long roleId);
    void remove(Long userId, Long roleId);
}
