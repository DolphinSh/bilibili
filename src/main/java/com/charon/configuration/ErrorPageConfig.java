package com.charon.configuration;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * 默认错误页跳转配置
 */
@Configuration
public class ErrorPageConfig implements ErrorPageRegistrar {
    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        //找不到页面
        ErrorPage errorPage404 = new ErrorPage(HttpStatus.NOT_FOUND, "/views/error/404.html");
        //内部服务器错误
        ErrorPage errorPage500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/views/error/500.html");
        //添加到配置中
        registry.addErrorPages(errorPage404, errorPage500);
    }
}
