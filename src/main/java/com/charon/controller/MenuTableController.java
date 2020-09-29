package com.charon.controller;

import com.alibaba.fastjson.JSON;
import com.charon.datasource.entity.MsgData;
import com.charon.datasource.entity.TableMenu;
import com.charon.datasource.entity.TableMsgData;
import com.charon.datasource.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class MenuTableController {
    @Autowired
    MenuService menuService;

    /**
     * 获取菜单所有信息
     * @return
     */
    @GetMapping("/api/getAllTableMenus")
    public String getAllTableMenus(){
        //获取所有菜单信息
        List<TableMenu> tableMenus = menuService.getAllTableMenus();
        //装进消息中心
        TableMsgData tableMsgData = new TableMsgData(0,"",tableMenus.size(),tableMenus);
        return JSON.toJSONString(tableMsgData);
    }

    /**
     * 删除菜单
     * @return 发送给前端的消息
     */
    @RequestMapping(value = "api/delTableMenuById",method = RequestMethod.POST)
    public String delTableMenuById(@RequestParam(value = "id", required = false) Integer id ){
        MsgData msgData = new MsgData();
        log.info("请求的删除的菜单id是--> {} ",id);
        // id 不为空判断
        if (id != null){
            boolean status = menuService.delMenu(id);
            //判断删除的状态
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
     * 添加菜单
     * @param parentId 夫菜单节点
     * @param authorityName
     * @param menuUrl
     * @param menuPath
     * @param menuIcon
     * @param isMenu
     * @return 发送给前端的消息
     */
    @RequestMapping(value = "api/addTableMenu",method = RequestMethod.POST)
    public String addTableMenu(@RequestParam(value = "parentId", required = false) Integer parentId,
                               @RequestParam(value = "authorityName", required = false) String authorityName,
                               @RequestParam(value = "menuUrl", required = false) String menuUrl,
                               @RequestParam(value = "menuPath", required = false) String menuPath,
                               @RequestParam(value = "menuIcon", required = false) String menuIcon,
                               @RequestParam(value = "isMenu", required = false) Integer isMenu){
        MsgData msgData = new MsgData();
        log.info("增加的菜单parentId：{}--authorityName：{}--menuUrl：{}--menuPath：{}--menuIcon{}--isMenu{}",parentId,authorityName,menuUrl,menuPath,menuIcon,isMenu);
        if (parentId!=null&&authorityName!=null&&menuUrl!=null&&menuPath!=null&&isMenu!=null){
            TableMenu tableMenu = new TableMenu();
            tableMenu.setParentId(parentId);
            tableMenu.setAuthorityName(authorityName);
            tableMenu.setMenuUrl("#"+menuUrl);
            tableMenu.setMenuPath(menuPath);
            tableMenu.setMenuIcon(menuIcon);
            tableMenu.setIsMenu(isMenu);
            boolean status = menuService.addMenu(tableMenu);
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
     * 更新菜单
     * @param parentId 父菜单id
     * @param authorityName 权限名
     * @param menuUrl 菜单Url
     * @param menuPath 菜单路径
     * @param menuIcon 菜单css样式
     * @param isMenu 是否为按钮
     * @param authorityId 排序id
     * @return 发送给前端的消息
     */
    @RequestMapping(value = "api/updTableMenu",method = RequestMethod.POST)
    public String updTableMenu(@RequestParam(value = "parentId", required = false) Integer parentId,
                               @RequestParam(value = "authorityName", required = false) String authorityName,
                               @RequestParam(value = "menuUrl", required = false) String menuUrl,
                               @RequestParam(value = "menuPath", required = false) String menuPath,
                               @RequestParam(value = "menuIcon", required = false) String menuIcon,
                               @RequestParam(value = "isMenu", required = false) Integer isMenu,
                               @RequestParam(value = "authorityId",required = false) Integer authorityId){

        MsgData msgData = new MsgData();
        log.info("增加的菜单parentId：{}--authorityName：{}--menuUrl：{}--menuPath：{}--menuIcon{}--isMenu{}",parentId,authorityName,menuUrl,menuPath,menuIcon,isMenu);
        if (parentId!=null&&authorityName!=null&&menuUrl!=null&&menuPath!=null&&isMenu!=null){
            TableMenu tableMenu = new TableMenu();
            tableMenu.setParentId(parentId);
            tableMenu.setAuthorityName(authorityName);
            tableMenu.setMenuUrl(menuUrl);
            tableMenu.setMenuPath(menuPath);
            tableMenu.setMenuIcon(menuIcon);
            tableMenu.setIsMenu(isMenu);
            tableMenu.setAuthorityId(authorityId);
            boolean status = menuService.updMenu(tableMenu);
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
