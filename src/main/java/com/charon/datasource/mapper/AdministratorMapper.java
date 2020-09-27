package com.charon.datasource.mapper;

import com.charon.datasource.entity.Administrator;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdministratorMapper {

    @Select("select id from administrator where id=#{id}")
    Administrator getAdministratorById(Integer id);

    @Select("select * from administrator where username=#{username}")
    Administrator getAdministratorByUsername(String username);
}
