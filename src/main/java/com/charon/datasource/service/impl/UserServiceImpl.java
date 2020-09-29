package com.charon.datasource.service.impl;

import com.charon.datasource.entity.Administrator;
import com.charon.datasource.entity.Permission;
import com.charon.datasource.entity.User;
import com.charon.datasource.mapper.UserMapper;
import com.charon.datasource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    /**
     * 获得所有的权限列表
     * @return
     */
    @Override
    public List<Permission> getAllPermission() {
        return userMapper.getAllPermission();
    }

    /**
     * 增加权限
     *
     * @param permission
     * @return true 增加成功 false 增加失败
     */
    @Override
    public boolean addPermission(Permission permission) {
        return userMapper.addPermission(permission);
    }

    /**
     * 删除权限
     *
     * @param id
     * @return true 删除成功 false 删除失败
     */
    @Override
    public boolean delPermission(Integer id) {
        return userMapper.delPermission(id);
    }

    /**
     * 更新权限
     *
     * @param permission
     * @return true 更新成功 false 更新失败
     */
    @Override
    public boolean updPermission(Permission permission) {
        return userMapper.updPermission(permission);
    }

    /**
     * 获取所有网站后台管理员
     *
     * @return 后台管理员List
     */
    @Override
    public List<Administrator> getAllAdministrators() {
        return userMapper.getAllAdministrators();
    }

    /**
     * 新增管理员
     *
     * @param administrator
     * @return true 新增成功 false 新增失败
     */
    @Override
    public boolean addAdministrator(Administrator administrator) {
        return userMapper.addAdministrator(administrator);
    }

    /**
     * 删除管理员
     *
     * @param id 管理员 id
     * @return true 删除成功 false 删除失败
     */
    @Override
    public boolean delAdministrator(Integer id) {
        return userMapper.delAdministrator(id);
    }

    /**
     * 更新管理员
     *
     * @param administrator
     * @return true 更新成功 false 更新失败
     */
    @Override
    public boolean updAdministrator(Administrator administrator) {
        return userMapper.updAdministrator(administrator);
    }

    /**
     * 更改状态
     *
     * @param id      id编号
     * @param enabled 启用状态
     * @return
     */
    @Override
    public boolean changeAdminEnabled(Integer id, Integer enabled) {

        return userMapper.changeAdminEnabled(id,enabled);
    }

    /**
     * 重置管理员密码
     * 6位随机密码
     *
     * @param id id编号
     * @return true 更新成功 false 更新失败
     */
    @Override
    public String restoreAdminPwd(Integer id) {
        String pwd = Math.round((Math.random()*9+1)*100000)+"";
        if (userMapper.restoreAdminPwd(id,pwd)){
            return pwd;
        }else {
            return "操作失败";
        }

    }

    /**
     * 获取所有网站用户
     *
     * @return
     */
    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    /**
     * 新增用户
     *
     * @param user
     * @return 新增成功 false 新增失败
     * @Param user
     */
    @Override
    public boolean addUser(User user) {
        return userMapper.addUser(user);
    }

    /**
     * 删除用户
     *
     * @param id 用户id
     * @return true 删除成功 false 删除失败
     */
    @Override
    public boolean delUser(Integer id) {
        return userMapper.delUser(id);
    }

    /**
     * 删除用户
     *
     * @param user
     * @return true 更新成功 false 更新失败
     */
    @Override
    public boolean updUser(User user) {
        return userMapper.updUser(user);
    }


}
