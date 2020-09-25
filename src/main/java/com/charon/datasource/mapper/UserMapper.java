package com.charon.datasource.mapper;

import com.charon.datasource.entity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
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
}
