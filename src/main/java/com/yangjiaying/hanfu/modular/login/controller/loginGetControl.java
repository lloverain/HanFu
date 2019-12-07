package com.yangjiaying.hanfu.modular.login.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @PackageName:com.yangjiaying.hanfu.modular.login.controller
 * @ClassName:loginGetControl
 * @author:yangjiaying
 * @date 2019/11/27 15:23
 */
@Controller
public class loginGetControl {
    private static Logger logger = LoggerFactory.getLogger(loginGetControl.class);

    private static String ROOT = "/modular/login/";

    @RequestMapping(value = "/login")
    public String login(){
        return ROOT+"login.html";
    }

    @RequestMapping(value = "/register")
    public String register(){
        return ROOT + "register.html";
    }
}
