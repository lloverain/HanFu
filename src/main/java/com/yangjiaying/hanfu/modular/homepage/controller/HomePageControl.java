package com.yangjiaying.hanfu.modular.homepage.controller;

import com.yangjiaying.hanfu.modular.system.service.UserLoginToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 主页
 * @PackageName:com.yangjiaying.hanfu.modular.homepage.controller
 * @ClassName:HomePageControl
 * @author:yangjiaying
 * @date 2019/11/5 23:24
 */
@Controller
public class HomePageControl {

    private static String ROOT = "/modular/";

    @RequestMapping("/homepage")
    public String tohomepage(){
        return ROOT + "HomePage.html";
    }
}
