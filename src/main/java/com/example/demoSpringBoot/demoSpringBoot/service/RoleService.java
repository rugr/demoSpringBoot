package com.example.demoSpringBoot.demoSpringBoot.service;

import com.example.demoSpringBoot.demoSpringBoot.entity.Role;

/**
 * Created by Ruslan on 29.08.2018.
 */
public interface RoleService {
    Role getById(Long id);
    void save(Role role);
    void delete(Long id);
}
