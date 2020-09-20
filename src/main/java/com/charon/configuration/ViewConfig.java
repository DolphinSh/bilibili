package com.charon.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 视图解析
 */
@Configuration
public class ViewConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //首页跳转
        registry.addViewController("/").setViewName("/views/index.html");
        registry.addViewController("/index").setViewName("/views/index.html");
    }
}
