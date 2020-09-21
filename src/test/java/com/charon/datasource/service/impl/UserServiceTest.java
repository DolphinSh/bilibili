package com.charon.datasource.service.impl;

import com.charon.datasource.entity.Permission;
import com.charon.datasource.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserService userService;
    @Test
    public void getAllPermission() {
        List<Permission> permissions = userService.getAllPermission();
        System.out.println(permissions);
    }
}