package com.charon.controller;

import com.alibaba.fastjson.JSON;
import com.charon.datasource.entity.MsgData;
import com.charon.datasource.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class IndexController {
    @Autowired
    MenuService menuService;

    @GetMapping("/api/getMenus")
    public String getAllmenus() {
        MsgData msgData = new MsgData(0, "", menuService.getAllMenu());
        return JSON.toJSONString(msgData);
    }
}
