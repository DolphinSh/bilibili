package com.charon.datasource.service;

import com.charon.datasource.entity.Administrator;

public interface AdministratorService {

    Administrator getAdministratorById(Integer id);

    Administrator getAdministratorByUsername(String username);
}
