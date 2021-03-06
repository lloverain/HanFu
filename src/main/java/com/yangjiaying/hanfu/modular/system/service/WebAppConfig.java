package com.yangjiaying.hanfu.modular.system.service;

import org.springframework.context.annotation.Bean;
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
        list.add("/login");
        list.add("/register");
        list.add("/getImage");
        registry.addInterceptor(requestAspect())
                .addPathPatterns("/**").excludePathPatterns(list);
        // 添加拦截的请求，并排除几个不拦截的请求
    }
    @Bean
    public RequestAspect requestAspect() {
        return new RequestAspect();
    }
}