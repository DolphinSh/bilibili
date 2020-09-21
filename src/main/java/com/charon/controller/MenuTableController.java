package com.charon.controller;

import com.alibaba.fastjson.JSON;
import com.charon.datasource.entity.TableMenus;
import com.charon.datasource.entity.TableMsgData;
import com.charon.datasource.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuTableController {
    @Autowired
    MenuService menuService;
    @GetMapping("/api/getAllTableMenus")
    public String getAllTableMenus(){
        //获取所有菜单信息
        List<TableMenus> tableMenus = menuService.getAllTableMenus();
        //装进消息中心
        TableMsgData tableMsgData = new TableMsgData(0,"",tableMenus.size(),tableMenus);
        return JSON.toJSONString(tableMsgData);
    }
}
