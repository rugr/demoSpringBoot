package com.example.demoSpringBoot.demoSpringBoot.service;

import com.example.demoSpringBoot.demoSpringBoot.dao.RoleDao;
import com.example.demoSpringBoot.demoSpringBoot.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by Ruslan on 29.08.2018.
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public Role getById(Long id) {
        return roleDao.findById(id).orElse(new Role());
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public void delete(Long id) {
        if(id == null) {
            return;
        }
        roleDao.deleteById(id);
    }

    @PostConstruct
    void init() {
        Role role = new Role();
        role.setId(1L);
        role.setName("ADMIN");
        save(role);
        role = new Role();
        role.setId(2L);
        role.setName("USER");
        save(role);
    }
}
