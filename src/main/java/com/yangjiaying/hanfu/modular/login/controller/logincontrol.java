package com.yangjiaying.hanfu.modular.login.controller;

import com.alibaba.fastjson.JSON;
import com.yangjiaying.hanfu.modular.login.entity.state;
import com.yangjiaying.hanfu.modular.login.entity.user;
import com.yangjiaying.hanfu.modular.login.service.loginservice;
import com.yangjiaying.hanfu.modular.login.util.Password;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 登录注册模块
 * @PackageName:com.yangjiaying.modular.controller
 * @ClassName:logincontrol
 * @author:yangjiaying
 * @date 2019/11/5 22:22
 */
@Controller
public class logincontrol {

    @Autowired
    private loginservice loginservice;

    private static String ROOTS = "/modular/login/";

    private static Logger logger = LoggerFactory.getLogger(logincontrol.class);

    /**
     * 访问登录页面
     * @return
     */
    @RequestMapping("/login")
    public String tologin(){
        return ROOTS +"login.html";
    }

    @RequestMapping("/register")
    public String toregister(){
        return ROOTS + "register.html";
    }

    /**
     * 登录验证接口
     * @param account
     * @param password
     * @param session
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public String login(@Param("account")String account, @Param("password")String password,
                        HttpSession session){
        System.out.println("login页面传来的参数"+account+"---"+password);
        user user = new user();
        user.setAccount(account);
        user.setPassword(Password.jiami(password,520));
        List<user> users = loginservice.selectuser(user);
        state state = new state();

        if(users.size() == 1){
            session.setAttribute("name",users.get(0).getName());
            state.setOther(users.get(0).getName());
            state.setCode("200");
            state.setContent("登录成功！");
            return JSON.toJSONString(state);
        }else {
            state.setCode("500");
            state.setContent("登录失败");
            return JSON.toJSONString(state);
        }
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public String register(user user,HttpSession session){
        user.setPassword(Password.jiami(user.getPassword(),520));
        int state_num = loginservice.register(user);
        state state = new state();
        if(state_num==1){
            session.setAttribute("name",user.getName());
            state.setCode("200");
            state.setContent("注册成功！");
            state.setOther(user.getName());
            return JSON.toJSONString(state);
        }else {
            state.setCode("500");
            state.setContent("注册失败！");
            return JSON.toJSONString(state);
        }
    }

    @RequestMapping(value = "/isItRegistered", method = RequestMethod.POST)
    @ResponseBody
    public String isItRegistered(String account){
        int state_num = loginservice.selectaccount(account);
        state state = new state();
        if(state_num==1){
            state.setCode("200");
            state.setContent("账户已存在！");
            return JSON.toJSONString(state);
        }else {
            state.setCode("500");
            state.setContent("账户可注册！");
            return JSON.toJSONString(state);
        }
    }
}
