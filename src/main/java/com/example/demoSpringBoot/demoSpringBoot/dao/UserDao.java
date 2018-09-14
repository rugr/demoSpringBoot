package com.example.demoSpringBoot.demoSpringBoot.dao;

import com.example.demoSpringBoot.demoSpringBoot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Ruslan on 29.08.2018.
 */
@Repository
public interface UserDao extends JpaRepository<User, Long> {
}
