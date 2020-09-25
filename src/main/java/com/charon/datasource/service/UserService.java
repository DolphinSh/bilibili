package com.charon.datasource.service;

import com.charon.datasource.entity.Permission;

import java.util.List;

public interface UserService {
    /**
     * 获得所有的权限
     * @return 权限List
     */
    List<Permission> getAllPermission();

    /**
     * 增加权限
     * @return true 增加成功 false 增加失败
     */
    boolean addPermission(Permission permission);

    /**
     * 删除权限
     * @return true 删除成功 false 删除失败
     */
    boolean delPermission(Integer id);

    /**
     * 更新权限
     * @return true 更新成功 false 更新失败
     */
    boolean updPermission(Permission permission);
}
