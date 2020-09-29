package com.charon.controller;

import com.alibaba.fastjson.JSON;
import com.charon.datasource.entity.*;
import com.charon.datasource.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
     * @return 处理后的消息代码
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
     * @return 处理后的消息代码
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

    /**
     * 更新权限
     * @param roleName 角色名
     * @param roleCode 角色代码
     * @param comments 备注
     * @param roleId 角色Id
     * @return 处理后的消息代码
     */
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

    /**
     * 获取所有的管理员
     * @return
     */
    @GetMapping("api/getAllAdministrators")
    public String getAllAdministrators(){
        List<Administrator> administrators = userService.getAllAdministrators();
        TableMsgData tableMsgData = new TableMsgData(0, "", administrators.size(), administrators);
        return JSON.toJSONString(tableMsgData);
    }

    /**
     * 增加管理员
     * @param username 用户名
     * @param password  密码
     * @param nickname 别名
     * @param mobile 电话
     * @param gender 性别
     * @param permission 权限
     * @return 消息状态
     */
    @RequestMapping(value = "api/addAdministrator",method = RequestMethod.POST)
    public String addAdministrator(@RequestParam(value = "username", required = false) String username,
                                   @RequestParam(value = "password", required = false) String password,
                                   @RequestParam(value = "nickname", required = false) String nickname,
                                   @RequestParam(value = "mobile", required = false) String mobile,
                                   @RequestParam(value = "gender", required = false) String gender,
                                   @RequestParam(value = "permission", required = false) String permission
                                   ){
        MsgData msgData = new MsgData();
        log.info("username -->{} password -->{} nickname -->{} mobile -->{} gender -->{} permission -->{}",
                username,password,nickname,mobile,gender,permission);
        if (username!=null&&password!=null&&nickname!=null&&mobile!=null&&gender!=null&&permission!=null){
            Administrator administrator = new Administrator();
            administrator.setUsername(username);
            administrator.setPassword(password);
            administrator.setNickname(nickname);
            administrator.setMobile(mobile);
            administrator.setGender(Integer.parseInt(gender));
            administrator.setPermission(Integer.parseInt(permission));
            boolean status = userService.addAdministrator(administrator);
            log.info("新增管理员状态 {}",status);
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
     * 删除管理员
     * @param id id排序号
     * @return 处理返回的JSON数据
     */
    @RequestMapping(value = "api/delAdministrator",method = RequestMethod.POST)
    public String delAdministrator(@RequestParam(value = "id", required = false) String id){
        MsgData msgData = new MsgData();
        log.info("请求的删除的id是--> {}",id);

        if (id != null){
            boolean status =  userService.delAdministrator(Integer.parseInt(id));
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
     * 更新管理员信息
     * @param username 账号名
     * @param password 密码
     * @param nickname 别名
     * @param mobile 电话
     * @param gender 性别
     * @param permission 权限
     * @param head_img_url 头像地址
     * @param enabled 启用
     * @param id id排序号
     * @param is_del 是否删除
     * @return 处理返回的JSON数据
     */
    @RequestMapping(value = "api/updAdministrator",method = RequestMethod.POST)
    public String updAdministrator(@RequestParam(value = "username", required = false) String username,
                                   @RequestParam(value = "password", required = false) String password,
                                   @RequestParam(value = "nickname", required = false) String nickname,
                                   @RequestParam(value = "mobile", required = false) String mobile,
                                   @RequestParam(value = "gender", required = false) String gender,
                                   @RequestParam(value = "permission", required = false) String permission,
                                   @RequestParam(value = "head_img_url", required = false) String head_img_url,
                                   @RequestParam(value = "enabled", required = false) String enabled,
                                   @RequestParam(value = "is_del", required = false) String is_del,
                                   @RequestParam(value = "id", required = false) String id){
        MsgData msgData = new MsgData();
        log.info("接收到数据 username -->{} password -->{} nickname -->{} mobile -->{} gender -->{} permission -->{} head_img_url-->" +
                        "{}head_img_url enabled-->{} is_del-->{} id-->{}",
                username,password,nickname,mobile,gender,permission,head_img_url,enabled,is_del,id);
        if (username!=null&&password!=null&&nickname!=null&&mobile!=null&&gender!=null&&permission!=null&&head_img_url!=null
        &&enabled!=null&&id!=null){
            Administrator administrator = new Administrator();
            administrator.setUsername(username);
            administrator.setPassword(password);
            administrator.setNickname(nickname);
            administrator.setMobile(mobile);
            administrator.setGender(Integer.parseInt(gender));
            administrator.setPermission(Integer.parseInt(permission));
            administrator.setHead_img_url(head_img_url);
            administrator.setEnabled(Integer.parseInt(enabled));
            administrator.setIs_del(Integer.parseInt(is_del));
            administrator.setId(Integer.parseInt(id));
            boolean status = userService.updAdministrator(administrator);
            log.info("测试更新管理员状态--->{}",status);
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
     * 获得所有用户
     * @return
     */
    @RequestMapping(value = "api/getAllUser",method = RequestMethod.POST)
    public String getAllUser(){
        List<User> users = userService.getAllUser();
        TableMsgData tableMsgData = new TableMsgData(0, "", users.size(), users);
        return JSON.toJSONString(tableMsgData);
    }

    /**
     * 增加用户
     * @param uid uid
     * @param nickname 别名
     * @param password 密码
     * @param gender 性别
     * @param age 年龄
     * @return 处理返回的JSON数据
     */
    @RequestMapping(value = "api/addUser",method = RequestMethod.POST)
    public String addUser(@RequestParam(value = "uid", required = false) String uid,
                          @RequestParam(value = "nickname", required = false) String nickname,
                          @RequestParam(value = "password", required = false) String password,
                          @RequestParam(value = "gender", required = false) String gender,
                          @RequestParam(value = "age", required = false) String age){
        MsgData msgData = new MsgData();
        log.info("uid -->{} nickname -->{} password -->{} gender -->{} age -->{}",uid,nickname,password,gender,age);
        if (uid!=null&&nickname!=null&&password!=null&&gender!=null&&age!=null){

            User user = new User();
            user.setUid(Integer.parseInt(uid));
            user.setNickname(nickname);
            user.setPassword(password);
            user.setGender(Integer.parseInt(gender));
            user.setAge(Integer.parseInt(age));
            boolean status = userService.addUser(user);
            log.info("测试增加用户状态-->{}",status);
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
     * 删除用户
     * @param id 用户排序id
     * @return 处理返回的JSON数据
     */
    @RequestMapping(value = "api/delUser",method = RequestMethod.POST)
    public String delUser(@RequestParam(value = "id", required = false) String id){
        MsgData msgData = new MsgData();
        log.info("请求的删除的id是--> {}",id);
        if (id != null){
            boolean status =  userService.delUser(Integer.parseInt(id));
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
     * 更新用户信息
     * @param uid 账号
     * @param nickname 别名
     * @param password 密码
     * @param gender 性别
     * @param age 年龄
     * @param head_img_url 头像地址
     * @param enable 启用状态
     * @param level 等级
     * @param is_del 是否删除
     * @param id id索引
     * @return 处理返回的JSON数据
     */
    @RequestMapping(value = "api/updUser",method = RequestMethod.POST)
    public String updUser(@RequestParam(value = "uid", required = false) String uid,
                          @RequestParam(value = "nickname", required = false) String nickname,
                          @RequestParam(value = "password", required = false) String password,
                          @RequestParam(value = "gender", required = false) String gender,
                          @RequestParam(value = "age", required = false) String age,
                          @RequestParam(value = "head_img_url", required = false) String head_img_url,
                          @RequestParam(value = "enable", required = false) String enable,
                          @RequestParam(value = "level", required = false) String level,
                          @RequestParam(value = "is_del", required = false) String is_del,
                          @RequestParam(value = "id", required = false) String id){
        MsgData msgData = new MsgData();
        log.info("uid -->{} nickname -->{} password -->{} gender -->{} age -->{} head_img_url-->{} enable-->{} level-->{} is_del-->{} id -->{}"
                ,uid,nickname,password,gender,age,head_img_url,enable,level,is_del,id);
        if (uid!=null&&nickname!=null&&password!=null&&gender!=null&&age!=null&&
                head_img_url!=null&&enable!=null&&level!=null&&is_del!=null){
                User user = new User();
                user.setUid(Integer.parseInt(uid));
                user.setNickname(nickname);
                user.setPassword(password);
                user.setGender(Integer.parseInt(gender));
                user.setAge(Integer.parseInt(age));
                user.setHead_img_url(head_img_url);
                user.setEnable(Integer.parseInt(enable));
                user.setIs_del(Integer.parseInt(is_del));
                user.setId(Integer.parseInt(id));
                boolean status = userService.updUser(user);
                log.info("执行更新管理员用户信息--->{}",status);
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
     * 更改管理员的启用状态
     * @param id id序号
     * @param enabled 启用状态 0 启用 1 锁定
     * @return 处理返回的JSON数据
     */
    @RequestMapping(value = "api/changAdminEnabled",method = RequestMethod.POST)
    public String changAdminEnabled(@RequestParam(value = "id", required = false) String id,
                                    @RequestParam(value = "enabled", required = false) String enabled){
        MsgData msgData = new MsgData();
        log.info("id-->{} enabled-->{}",id,enabled);
        if (id!=null&& enabled!=null){
            boolean status = userService.changeAdminEnabled(Integer.parseInt(id),Integer.parseInt(enabled));
            log.info("执行更改管理员启用状态--->{}",status);
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
     * 重置管理员登录密码
     * @param id 账户排序号
     * @return 处理返回的JSON数据
     */
    @RequestMapping(value = "api/restoreAdminPwd",method = RequestMethod.POST)
    public String restoreAdminPwd(@RequestParam(value = "id", required = false) String id){
        MsgData msgData = new MsgData();
        log.info("id-->{} ",id);
        if (id!=null){
            String result =  userService.restoreAdminPwd(Integer.parseInt(id));
            if (result!="操作失败"){
                msgData.setMsg("重置后的密码为"+result);
                msgData.setCode(200);
            }
        }else {
            msgData.setMsg("操作失败");
            msgData.setCode(-1);
        }
        return JSON.toJSONString(msgData);

    }
}
