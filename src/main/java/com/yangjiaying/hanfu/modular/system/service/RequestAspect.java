package com.yangjiaying.hanfu.modular.system.service;
import com.alibaba.fastjson.JSON;
import com.yangjiaying.hanfu.modular.login.entity.state;
import org.apache.ibatis.mapping.ResultMap;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @PackageName:com.yangjiaying.hanfu.modular.system.service
 * @ClassName:RequestAspect
 * @author:yangjiaying
 * @date 2019/11/5 23:30
 */
/**
 * 拦截器，登录检查
 */
@Component
public class RequestAspect implements HandlerInterceptor {
    private static String ROOT = "/modular/login/";
    // 目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("name");
        System.out.println("拦截器获取:"+user);
        // 如果获取的request的session中的user参数为空（未登录），就返回登录页，否则放行访问
        if (user == null) {
            // 获取request返回页面到登录页
            response.sendRedirect("/login");
            return false;
        } else {
            // 已登录，放行
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }


}