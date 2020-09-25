package com.charon.controller;

import com.alibaba.fastjson.JSON;
import com.charon.datasource.entity.MsgData;
import com.charon.datasource.entity.Permission;
import com.charon.datasource.entity.TableMsgData;
import com.charon.datasource.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 获取所有的权限
     * @return List<Permission>
     */
    @GetMapping("api/getAllpermissions")
    public String getAllpermissions() {
        List<Permission> permissions = userService.getAllPermission();
        TableMsgData tableMsgData = new TableMsgData(0, "", permissions.size(), permissions);
        return JSON.toJSONString(tableMsgData);
    }

    /**
     * 增加角色
     * @param roleName 角色名
     * @param roleCode 角色代码
     * @param comments 备注
     * @return
     */
    @RequestMapping(value = "api/addPermission",method = RequestMethod.POST)
    public String addPermission(@RequestParam(value = "roleName", required = false) String roleName,
                                @RequestParam(value = "roleCode", required = false) String roleCode,
                                @RequestParam(value = "comments", required = false) String comments) {
        MsgData msgData = new MsgData();
        log.info("roleName ：{}--roleCode ：{}--comments ：{}",roleName,roleCode,comments);
        //不为空判断
        if (roleName!=null&&roleCode!=null&&comments!=null){
            Permission permission = new Permission();
            permission.setRoleName(roleName);
            permission.setRoleCode(roleCode);
            permission.setComments(comments);
            boolean status = userService.addPermission(permission);
            if (status){
                msgData.setMsg("操作成功");
                msgData.setCode(200);
            }
        }else {
            msgData.setMsg("操作失败");
            msgData.setCode(-1);
        }
        return JSON.toJSONString(msgData);
    }

    /**
     * 删除角色
     * @param id 角色id号
     * @return
     */
    @RequestMapping(value = "api/delPermission",method = RequestMethod.POST)
    public String delPermission(@RequestParam(value = "id", required = false) String id){
        MsgData msgData = new MsgData();
        log.info("请求的删除的id是--> {}",id);
        if (id != null){
            boolean status =  userService.delPermission(Integer.parseInt(id));
            if (status){
                msgData.setMsg("操作成功");
                msgData.setCode(200);
            }
        }else {
            msgData.setMsg("操作失败");
            msgData.setCode(-1);
        }
        return JSON.toJSONString(msgData);
    }

    @RequestMapping(value = "api/updPermission",method = RequestMethod.POST)
    public String updPermission(@RequestParam(value = "roleName", required = false) String roleName,
                                @RequestParam(value = "roleCode", required = false) String roleCode,
                                @RequestParam(value = "comments", required = false) String comments,
                                @RequestParam(value = "roleId",required = false) Integer roleId){

        MsgData msgData = new MsgData();
        log.info("权限更新功能--> roleName ：{}--roleCode ：{}--comments ：{}",roleName,roleCode,comments);
        //不为空判断
        if (roleName!=null&&roleCode!=null&&comments!=null){
            Permission permission = new Permission();
            permission.setRoleName(roleName);
            permission.setRoleCode(roleCode);
            permission.setComments(comments);
            permission.setRoleId(roleId);
            boolean status = userService.updPermission(permission);
            if (status){
                msgData.setMsg("操作成功");
                msgData.setCode(200);
            }
        }else {
            msgData.setMsg("操作失败");
            msgData.setCode(-1);
        }
        return JSON.toJSONString(msgData);
    }
}
