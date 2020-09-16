package com.charon.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller

public class KaptchaController {
    @Autowired
    private Producer producer = null;

    @GetMapping("/captcha")
    public void getKaptchaImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        response.setDateHeader("Expires", 0);

        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");/*浏览器和任何中继的Web代理，都不会存储这次相应的数据*/
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");/**/

        //生成验证码
        String capText = producer.createText();
        session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
        // 输出验证码
        BufferedImage bi = producer.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(bi, "jpg", out);
        out.flush();
        out.close();
    }
}