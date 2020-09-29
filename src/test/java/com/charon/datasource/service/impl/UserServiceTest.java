package com.charon.datasource.service.impl;

import com.charon.datasource.entity.Administrator;
import com.charon.datasource.entity.Permission;
import com.charon.datasource.entity.User;
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

    /**
     * 测试获取所有的管理员账户
     */
    @Test
    public void getAllAdministrators(){
        List<Administrator> administrators = userService.getAllAdministrators();
        System.out.println(administrators);
    }

    /**
     * 测试增加管理员
     */
    @Test
    public void addAdministrator(){
        Administrator administrator = new Administrator();
        administrator.setUsername("test");
        administrator.setPassword("123456");
        administrator.setNickname("测试人员");
        administrator.setMobile("11111111111");
        administrator.setGender(0);
        administrator.setPermission(1);
        //administrator.setHead_img_url("upload//img//user");
        boolean status = userService.addAdministrator(administrator);
        System.out.println("测试增加管理员状态--->"+status);
    }

    /**
     * 测试删除管理员
     */
    @Test
    public void delAdministrator(){
        boolean status = userService.delAdministrator(4);

        System.out.println("测试删除管理员状态--->"+status);
    }

    /***
     * 测试更新管理员信息
     */
    @Test
    public void updAdministrator(){
        Administrator administrator = new Administrator();
        administrator.setUsername("test");
        administrator.setPassword("123465");//
        administrator.setNickname("测试人员");
        administrator.setMobile("11111111111");
        administrator.setGender(0);
        administrator.setPermission(1);
        administrator.setHead_img_url("upload//img//user");
        administrator.setEnabled(0);
        administrator.setId(4);
        administrator.setIs_del(1);
        boolean status = userService.updAdministrator(administrator);
        System.out.println("测试更新管理员状态--->"+status);
    }

    /**
     * 获得所有的用户
     */
    @Test
    public void getAllUser(){
        List<User> users = userService.getAllUser();
        System.out.println("测试获得所有用户状态--->"+users);
    }

    /**
     *
     * 增加用户
     */
    @Test
    public void addUser(){
        User user = new User();
        user.setUid(10001);
        user.setNickname("张三");
        user.setPassword("123456");
        user.setGender(2);
        user.setAge(100);
        boolean status = userService.addUser(user);
        System.out.println("测试增加用户状态--->"+status);
    }

    /**
     *
     * 删除用户
     */
    @Test
    public void delUser(){
        boolean status = userService.delUser(1);
        System.out.println("测试删除用户状态--->"+status);
    }

    /**
     *
     * 更新用户
     */
    @Test
    public void updUser(){
        User user = new User();
        user.setUid(10001);
        user.setNickname("张三更新");
        user.setPassword("123456");
        user.setGender(2);
        user.setAge(100);
        user.setHead_img_url("upload//img//user");
        user.setEnable(1);
        user.setIs_del(1);
        user.setId(1);
        boolean status = userService.updUser(user);
        System.out.println("测试更新用户状态--->"+status);
    }
    @Test
    public void changeAdminEnabledTest(){
        boolean status = userService.changeAdminEnabled(4,0);
        System.out.println("测试更改管理员启用状态--->"+status);
    }
    @Test
    public void restoreAdminPwdTest(){
        System.out.println("重置后的密码"+userService.restoreAdminPwd(4));
    }
}