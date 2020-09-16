package com.charon.configuration;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class KaptchaConfig {
    @Bean
    public DefaultKaptcha getDefaultKaptcha(){
        DefaultKaptcha captchaProducer = new DefaultKaptcha();
        Properties properties = new Properties();
        properties.setProperty("kaptcha.border", "yes");/*边框*/
        properties.setProperty("kaptcha.border.color", "105,179,90");/*边框的颜色*/
        properties.setProperty("kaptcha.textproducer.font.color", "blue");/*字体的颜色*/
        properties.setProperty("kaptcha.image.width", "100");/*验证码宽*/
        properties.setProperty("kaptcha.image.height", "38");/*验证码高*/
        properties.setProperty("kaptcha.textproducer.font.size", "30");/*字体的大小*/
        properties.setProperty("kaptcha.session.key", "code");/**/
        properties.setProperty("kaptcha.textproducer.char.length", "4");
        properties.setProperty("kaptcha.textproducer.font.names", "宋体,楷体,微软雅黑");
        Config config = new Config(properties);
        captchaProducer.setConfig(config);
        return captchaProducer;
    }
}
