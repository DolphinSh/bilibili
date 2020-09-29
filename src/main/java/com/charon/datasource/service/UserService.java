package com.charon.datasource.service;

import com.charon.datasource.entity.Administrator;
import com.charon.datasource.entity.Permission;
import com.charon.datasource.entity.User;
import org.apache.ibatis.annotations.Update;

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

    /**
     * 获取所有网站后台管理员
     * @return 后台管理员List
     */
    List<Administrator> getAllAdministrators();

    /**
     * 新增管理员
     * @param administrator
     * @return true 新增成功 false 新增失败
     */
    boolean addAdministrator(Administrator administrator);

    /**
     * 删除管理员
     * @param id 管理员 id
     * @return true 删除成功 false 删除失败
     */
    boolean delAdministrator(Integer id);

    /**
     * 更新管理员
     * @param administrator
     * @return true 更新成功 false 更新失败
     */
    boolean updAdministrator(Administrator administrator);
    /**
     * 更改状态
     * @param id id编号
     * @param enabled 启用状态
     * @return
     */
    boolean changeAdminEnabled(Integer id, Integer enabled);

    /**
     * 重置管理员密码
     * @param id id编号
     * @return true 更新成功 false 更新失败
     */
    String restoreAdminPwd(Integer id);
    /*####################用户#####################*/

    /**
     * 获取所有网站用户
     * @return
     */
    List<User> getAllUser();

    /**
     * 新增用户
     * @Param user
     * @return 新增成功 false 新增失败
     */
    boolean addUser(User user);

    /**
     * 删除用户
     * @param id 用户id
     * @return true 删除成功 false 删除失败
     */
    boolean delUser(Integer id);

    /**
     * 删除用户
     * @param user
     * @return true 更新成功 false 更新失败
     */
    boolean updUser(User user);
}
