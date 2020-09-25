package com.charon.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 视图解析
 */
@Configuration
class ViewConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("/views/index.html");
        registry.addViewController("/setting/menu_setting").setViewName("/views/setting/menu_setting.html");
    }
}