package com.charon.shiro.config;

import com.charon.datasource.entity.Administrator;
import com.charon.datasource.service.AdministratorService;
import com.charon.utils.ApplicationContextUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.util.ObjectUtils;

public class CustomerRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //根据身份信息
        String principal = (String) authenticationToken.getPrincipal();
        //在工厂获取service对象
        AdministratorService administratorService = (AdministratorService) ApplicationContextUtils.getBean("AdministratorService");
        System.out.println(administratorService);
        Administrator administrator = administratorService.getAdministratorByUsername(principal);
        //Administrator admin = administratorService.getAdministratorByUsername(username);
        if (!ObjectUtils.isEmpty(administrator)){
            return new SimpleAuthenticationInfo(administrator.getUsername(),administrator.getPassword(),this.getName());
        }
        return null;
    }
}
