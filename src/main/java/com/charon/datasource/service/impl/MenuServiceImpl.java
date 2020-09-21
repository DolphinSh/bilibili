package com.charon.datasource.service.impl;

import com.charon.datasource.entity.Menu;
import com.charon.datasource.entity.TableMenus;
import com.charon.datasource.mapper.MenuMapper;
import com.charon.datasource.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuMapper menuMapper;
    @Override
    public List<Menu> getAllMenu() {
        return menuMapper.getAllMenu();
    }

    @Override
    public List<TableMenus> getAllTableMenus() {
        return menuMapper.getAllTableMenus();
    }
}
