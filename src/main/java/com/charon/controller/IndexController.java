package com.charon.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.charon.datasource.entity.MsgData;
import com.charon.datasource.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class IndexController {
    @Autowired
    MenuService menuService;

    @GetMapping("/index")
    public String view_index() {
        return "index";
    }
    @GetMapping("/setting/menu_setting")
    public String view_menuSetting() {
        return "setting/menu_setting";
    }

    @GetMapping("/api/getMenus")
    @ResponseBody
    public String getAllmenus() {
        MsgData msgData = new MsgData(0, "", menuService.getAllMenu());
        return JSON.toJSONString(msgData);
    }
}
