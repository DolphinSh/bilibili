package com.charon.datasource.service.impl;

import com.charon.datasource.entity.Menu;
import com.charon.datasource.service.MenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
@SpringBootTest
public class MenuServicelTest {
    @Autowired
    MenuService menuService;

    @Test
    public void getAllMenu() {
        List<Menu> menus =  menuService.getAllMenu();
        System.out.println(menus);
    }
}