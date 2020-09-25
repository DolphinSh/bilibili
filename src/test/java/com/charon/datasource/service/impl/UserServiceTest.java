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

    /**
     * 测试更新权限
     */
    @Test
    public void getAllPermission() {
        List<Permission> permissions = userService.getAllPermission();
        System.out.println(permissions);
    }

    /**
     * 增加权限
     */
    @Test
    public void addPermission(){
        Permission permission = new Permission();
        permission.setRoleName("测试增加权限");
        permission.setRoleCode("testOptionAdd");
        permission.setComments("测试CURD");
        boolean status = userService.addPermission(permission);
        System.out.println(status);
    }

    /**
     * 删除权限
     */
    @Test
    public void delPermission(){
        boolean status = userService.delPermission(6);
        System.out.println(status);
    }

    /**
     * 更新权限
     */
    @Test
    public void updPermission(){
        Permission permission = new Permission();
        permission.setRoleName("测试更新权限");
        permission.setRoleCode("testOptionAdd");
        permission.setComments("测试CURD");
        permission.setRoleId(6);
        boolean status = userService.updPermission(permission);
        System.out.println(status);
    }
}