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
}
