package com.charon.datasource.mapper;

import com.charon.datasource.entity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT id as roleId,roleName,note as comments,code as roleCode,createTime,updateTime FROM permission")
    List<Permission> getAllPermission();
}
