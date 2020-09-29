package com.charon.controller;

import com.charon.datasource.entity.Administrator;
import com.charon.datasource.service.AdministratorService;
import com.charon.datasource.vo.MsgData;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@Slf4j
@Controller
public class LoginController {
    @Autowired
    AdministratorService administratorService;

    @PostMapping("/token")
    @ResponseBody
    public MsgData token(@RequestParam("username") String username,
                         @RequestParam("password") String password,
                         HttpSession session) {
        log.info("{} {}", username, password);
        if (username==null||password==null){
            return new MsgData(-1, "fail");
        }
        //1.获取主体对象
        Subject subject = SecurityUtils.getSubject();
        try{
            //2.进行登录
             subject.login(new UsernamePasswordToken(username,password));
             return new MsgData(0, UUID.randomUUID().toString());
        }catch (Exception e){
            e.printStackTrace();
            return new MsgData(-1, "fail");
        }
    }

    /**
     * 退出登录
     *
     * @return
     */
    @RequestMapping("/api/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();//退出登录
        //发送信息给前端
        return null;
    }
}
