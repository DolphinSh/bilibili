package com.charon.controller;

import com.charon.datasource.entity.Administrator;
import com.charon.datasource.service.AdministratorService;
import com.charon.datasource.vo.MsgData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
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
        Administrator admin = administratorService.getAdministratorByUsername(username);
        if (admin == null) {
            return new MsgData(-1, "fail");
        }
        if (!admin.getPassword().equals(password)) {
            return new MsgData(-1, "fail");
        }
        session.setAttribute("token","qwdnqwilfhqwoihfioqw");
        return new MsgData(0, UUID.randomUUID().toString());
    }
}
