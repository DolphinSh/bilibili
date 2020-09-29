package com.charon.datasource.service.impl;

import com.charon.datasource.entity.Administrator;
import com.charon.datasource.mapper.AdministratorMapper;
import com.charon.datasource.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("AdministratorService")
@Transactional
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    AdministratorMapper administratorMapper;

    @Override
    public Administrator getAdministratorById(Integer id) {
        return administratorMapper.getAdministratorById(id);
    }

    public Administrator getAdministratorByUsername(String username){
        return administratorMapper.getAdministratorByUsername(username);
    }
}
