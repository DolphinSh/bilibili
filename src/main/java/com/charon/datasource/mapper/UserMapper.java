package com.charon.datasource.mapper;

import com.charon.datasource.entity.Administrator;
import com.charon.datasource.entity.Permission;
import com.charon.datasource.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.data.relational.core.sql.From;

import java.util.List;

@Mapper
public interface UserMapper {
    /*####################权限列表#####################*/
    /**
     * 获得所有的权限
     * @return 权限List
     */
    @Select("SELECT id as roleId,roleName,note as comments,code as roleCode,createTime,updateTime FROM permission")
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
    /*####################管理员#####################*/
    /**
     * 获取所有网站后台管理员
     * @return 后台管理员List
     */
    @Select("SELECT * FROM administrator")
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
     * @return true 更新成功 false 更新失败
     */
    @Update("UPDATE administrator SET enabled = #{enabled} WHERE id = #{id}")
    boolean changeAdminEnabled(Integer id, Integer enabled);

    /**
     * 重置管理员密码
     * @param id id编号
     * @param password 随机生成密码
     * @return true 更新成功 false 更新失败
     */
    @Update("UPDATE administrator SET password = #{password} WHERE id = #{id}")
    Boolean restoreAdminPwd(Integer id,String password);
    /*####################用户#####################*/

    /**
     * 获取所有网站用户
     * @return
     */
    @Select("SELECT * FROM user")
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
