package com.charon.datasource.service;

import com.charon.datasource.entity.Menu;
import com.charon.datasource.entity.TableMenu;

import java.util.List;

public interface MenuService {
    /**
     * 获得所有的菜单+层级样式
     * @return List<Menu> 菜单的数据
     */
    List<Menu> getAllMenu();
    /**
     * 菜单表格查询所有的菜单
     * @return
     */
    List<TableMenu> getAllTableMenus();

    /**
     * 新增菜单
     * @return true 新增成功 false 新增失败
     * @param tableMenu 菜单的信息
     */
    boolean addMenu(TableMenu tableMenu);

    /**
     * 删除菜单
     * @param id 删除菜单的id 排序号
     * @return true 删除成功 flase 删除失败
     */
    boolean delMenu(Integer id);

    /**
     * 修改菜单
     * @param tableMenu 菜单的信息
     * @return
     */
    boolean updMenu(TableMenu tableMenu);
}
