package com.charon.controller;

import com.charon.datasource.entity.Administrator;
import com.charon.datasource.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdministratorController {

    @Autowired
    AdministratorService administratorService;

    @GetMapping("/admin/{id}")
    @ResponseBody
    public Administrator admin(@PathVariable("id") Integer id) {
        return administratorService.getAdministratorById(id);
    }
}
