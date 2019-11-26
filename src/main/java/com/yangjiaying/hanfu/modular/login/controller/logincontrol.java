package com.yangjiaying.hanfu.modular.login.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yangjiaying.hanfu.modular.login.entity.loginResponse;
import com.yangjiaying.hanfu.modular.login.entity.user;
import com.yangjiaying.hanfu.modular.login.service.loginservice;
import com.yangjiaying.hanfu.modular.login.util.Password;
import com.yangjiaying.hanfu.modular.login.util.jiexiJSON;
import com.yangjiaying.hanfu.modular.system.entity.RestResponse;
import com.yangjiaying.hanfu.modular.system.service.Impl.TokenUtil;
import com.yangjiaying.hanfu.modular.system.service.UserLoginToken;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * 登录注册模块
 *
 * @PackageName:com.yangjiaying.modular.controller
 * @ClassName:logincontrol
 * @author:yangjiaying
 * @date 2019/11/5 22:22
 */
@Controller
@RequestMapping(value = "/API")
public class logincontrol {

    @Autowired
    private loginservice loginservice;

    private static Logger logger = LoggerFactory.getLogger(logincontrol.class);

    @RequestMapping("/signout")
    @UserLoginToken
    @ResponseBody
    public String signOut() {
        return "";
    }

    /**
     * 登录验证接口
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(HttpServletRequest request) throws NoSuchPaddingException, BadPaddingException, InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, IOException, InvalidAlgorithmParameterException {
        jiexiJSON jiexiJSON = new jiexiJSON();
        String json = jiexiJSON.jiexi(request);
        JSONObject jsonObject = JSON.parseObject(json);
        user user = new user();
        TokenUtil tokenUtil = new TokenUtil();
        user.setAccount(jsonObject.getString("account"));
        user.setPassword(Password.jiami(jsonObject.getString("password")));
        List<user> users = loginservice.selectuser(user);
        System.out.println(users.toString());
        RestResponse response = new RestResponse();
        if (users.size() == 1) {
            String token = tokenUtil.getToken(users.get(0));
            loginResponse loginResponse = new loginResponse();
            loginResponse.setAccount(users.get(0).getAccount());
            loginResponse.setName(users.get(0).getName());
            loginResponse.setSex(users.get(0).getSex());
            loginResponse.setToken(token);
            response.setCode(200);
            response.setMessage("/getMessage");
            response.setData(loginResponse);
            return JSON.toJSONString(response);
        } else {
            response.setCode(500);
            response.setMessage("/404");
            response.setData("账户登录失败！");
            return JSON.toJSONString(response);
        }
    }
    @UserLoginToken
    @RequestMapping("/getMessage")
    @ResponseBody
    public String getMessage(){
        return "你已通过验证";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public String register(HttpServletRequest request) throws IOException, NoSuchPaddingException, InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
        jiexiJSON jiexiJSON = new jiexiJSON();
        String json = jiexiJSON.jiexi(request);
        JSONObject jsonObject = JSON.parseObject(json);

        RestResponse response = new RestResponse();
        user user = new user();

        user.setAccount(jsonObject.getString("account"));
        user.setPassword(Password.jiami(jsonObject.getString("password")));
        user.setName(jsonObject.getString("name"));
        user.setSex(jsonObject.getString("sex"));

        try {
            int state_num = loginservice.register(user);
            if(state_num ==1 ){
                response.setCode(200);
                response.setMessage("注册成功！");
            }
        }catch (Exception e){
            e.printStackTrace();
            response.setCode(500);
            response.setMessage("注册失败");
            response.setData(e.getMessage());
        }
        return JSON.toJSONString(response);
    }

    @RequestMapping(value = "/isItRegistered", method = RequestMethod.POST)
    @ResponseBody
    public String isItRegistered(HttpServletRequest request) throws IOException {
        jiexiJSON jiexiJSON = new jiexiJSON();
        String json = jiexiJSON.jiexi(request);
        JSONObject jsonObject = JSON.parseObject(json);
        String account = jsonObject.getString("account");
        int state_num = loginservice.selectaccount(account);
        RestResponse response = new RestResponse();
        if (state_num == 1) {
            response.setCode(200);
            response.setMessage("账户已存在！");
        } else {
            response.setCode(500);
            response.setMessage("账户"+account+"可注册！");

        }
        return JSON.toJSONString(response);
    }
}
