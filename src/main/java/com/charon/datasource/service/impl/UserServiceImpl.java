package com.charon.datasource.service.impl;

import com.charon.datasource.entity.Permission;
import com.charon.datasource.mapper.UserMapper;
import com.charon.datasource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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


}
