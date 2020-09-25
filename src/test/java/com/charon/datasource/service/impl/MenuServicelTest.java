package com.charon.datasource.service.impl;

import com.charon.datasource.entity.Menu;
import com.charon.datasource.entity.TableMenu;
import com.charon.datasource.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
@SpringBootTest
@Slf4j
public class MenuServicelTest {
    @Autowired
    MenuService menuService;

    /**
     * 测试获取左侧菜单列表
     */
    @Test
    public void getAllMenu() {
        List<Menu> menus =  menuService.getAllMenu();
        System.out.println(menus);
    }

    /**
     * 测试获得所有的菜单
     */
    @Test
    public void getAllTableMenus(){
        List<TableMenu> tableMenus = menuService.getAllTableMenus();
        System.out.println(tableMenus);
    }

    /**
     * 测试增加菜单
     */
    @Test
    public void addMenu(){
        TableMenu tableMenu = new TableMenu();
        tableMenu.setParentId(1);
        tableMenu.setAuthorityName("测试添加菜单");
        tableMenu.setMenuUrl("#!TestMenuAdd");
        tableMenu.setMenuPath("/test/add.html");
        tableMenu.setMenuIcon(null);
        tableMenu.setIsMenu(1);
        boolean status =  menuService.addMenu(tableMenu);
        System.out.println(status);
    }

    /**
     * 测试删除菜单
     */
    @Test
    public void delMenu(){
        boolean status = menuService.delMenu(30);
        log.info("菜单删除测试--> {}",status);
    }

    /**
     * 测试更新菜单
     */
    @Test
    public void updMenu(){
        TableMenu tableMenu = new TableMenu();
        tableMenu.setParentId(1);
        tableMenu.setAuthorityId(30);
        tableMenu.setMenuUrl("#!TestMenuAdd");
        tableMenu.setMenuPath("/test/add.html");
        tableMenu.setAuthorityName("测试更新菜单的名字");
        tableMenu.setMenuIcon(null);
        tableMenu.setIsMenu(1);
        boolean status = menuService.updMenu(tableMenu);
        log.info("菜单更新测试--> {}",status);
    }

}