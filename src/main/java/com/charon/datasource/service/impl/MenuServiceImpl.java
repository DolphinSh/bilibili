package com.charon.datasource.service.impl;

import com.charon.datasource.entity.Menu;
import com.charon.datasource.entity.TableMenu;
import com.charon.datasource.mapper.MenuMapper;
import com.charon.datasource.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuMapper menuMapper;

    /**
     * 获得所有的菜单+层级样式
     * @return List<Menu> 菜单的数据
     */
    @Override
    public List<Menu> getAllMenu() {
        return menuMapper.getAllMenu();
    }

    /**
     * 菜单表格查询所有的菜单
     * @return
     */
    @Override
    public List<TableMenu> getAllTableMenus() {
        return menuMapper.getAllTableMenus();
    }

    /**
     * 新增菜单
     *
     * @param tableMenu 菜单的信息
     * @return true 新增成功 false 新增失败
     */
    @Override
    public boolean addMenu(TableMenu tableMenu) {
        return menuMapper.addMenu(tableMenu);
    }

    /**
     * 删除菜单
     *
     * @param id 删除菜单的id 排序号
     * @return true 删除成功 flase 删除失败
     */
    @Override
    public boolean delMenu(Integer id) {
        return menuMapper.delMenu(id);
    }

    /**
     * 修改菜单
     *
     * @param tableMenu 菜单的信息
     * @return
     */
    @Override
    public boolean updMenu(TableMenu tableMenu) {
        return menuMapper.updMenu(tableMenu);
    }
}
