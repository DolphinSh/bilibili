package com.charon.controller;

import com.alibaba.fastjson.JSON;
import com.charon.datasource.entity.MsgData;
import com.charon.datasource.entity.Permission;
import com.charon.datasource.entity.TableMsgData;
import com.charon.datasource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("api/getAllpermissions")
    public String getAllpermissions(){
        List<Permission> permissions = userService.getAllPermission();
        TableMsgData tableMsgData = new TableMsgData(0,"",permissions.size(),permissions);
        return JSON.toJSONString(tableMsgData);
    }
}
