package com.yangjiaying.hanfu.modular.system.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @PackageName:com.yangjiaying.hanfu.modular.system.service
 * @ClassName:MyWebAppConfigurer
 * @author:yangjiaying
 * @date 2019/11/6 11:01
 */
@Configuration
    public class WebAppConfig extends WebMvcConfigurerAdapter {
    //实现拦截器 要拦截的路径以及不拦截的路径
    /**
     * 注册 拦截器
     * 这里添加要拦截的页面
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> list = new ArrayList<>();
        list.add("/homepage");
        registry.addInterceptor(new RequestAspect()).addPathPatterns(list);
    }

}