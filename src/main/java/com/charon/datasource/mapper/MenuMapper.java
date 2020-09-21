package com.charon.datasource.mapper;

import com.charon.datasource.entity.Menu;
import com.charon.datasource.entity.TableMenus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface MenuMapper {

    List<Menu> getAllMenu();

    @Select("SELECT id as authorityId,name as authorityName,url as menuUrl,parentId,type as isMenu,path as menuPath,css as menuIcon,createTime,updateTime FROM menu")
    List<TableMenus> getAllTableMenus();
}
