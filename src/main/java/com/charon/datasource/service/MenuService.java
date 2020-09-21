package com.charon.datasource.service;

import com.charon.datasource.entity.Menu;
import com.charon.datasource.entity.TableMenus;

import java.util.List;

public interface MenuService {
    List<Menu> getAllMenu();
    List<TableMenus> getAllTableMenus();
}
