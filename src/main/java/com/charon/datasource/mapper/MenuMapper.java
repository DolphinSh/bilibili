package com.charon.datasource.mapper;

import com.charon.datasource.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MenuMapper {

    List<Menu> getAllMenu();
}
