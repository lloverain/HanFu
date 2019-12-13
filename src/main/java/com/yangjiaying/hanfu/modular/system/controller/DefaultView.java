package com.yangjiaying.hanfu.modular.system.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 这是一个启动默认设置页面类
 * @PackageName:com.yangjiaying.hanfu.modular.system.controller
 * @ClassName:DefaultView
 * @author:yangjiaying
 * @date 2019/11/12 11:55
 */
@Configuration
public class DefaultView implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/pages/modular/login/login.html");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
}