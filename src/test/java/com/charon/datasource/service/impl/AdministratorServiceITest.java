package com.charon.datasource.service.impl;

import com.charon.datasource.service.AdministratorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class AdministratorServiceITest {
    @Autowired
    AdministratorService administratorService;
    @Test
    void getAdministratorById() {
        System.out.println(administratorService.getAdministratorById(2));
    }
}