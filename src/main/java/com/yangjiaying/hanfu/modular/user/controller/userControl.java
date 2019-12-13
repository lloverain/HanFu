package com.yangjiaying.hanfu.modular.user.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yangjiaying.hanfu.modular.login.util.Password;
import com.yangjiaying.hanfu.modular.system.util.jiexiJSON;
import com.yangjiaying.hanfu.modular.system.entity.RestResponse;
import com.yangjiaying.hanfu.modular.system.service.UserLoginToken;
import com.yangjiaying.hanfu.modular.user.service.userservice;
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
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @PackageName:com.yangjiaying.hanfu.modular.user.controller
 * @ClassName:UserControl
 * @author:yangjiaying
 * @date 2019/12/11 18:03
 */
@Controller
@RequestMapping(value = "/API/user")
public class userControl {

    @Autowired
    private userservice userservice;

    private static Logger logger = LoggerFactory.getLogger(userControl.class);

    /**
     * 用户修改密码
     *
     * @param request
     * @return
     * @throws IOException
     */
    @UserLoginToken
    @RequestMapping(value = "/alertpw", method = RequestMethod.POST)
    @ResponseBody
    public String alertpw(HttpServletRequest request) throws IOException, NoSuchPaddingException, InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
        jiexiJSON jiexiJSON = new jiexiJSON();
        String json = jiexiJSON.jiexi(request);
        JSONObject jsonObject = JSON.parseObject(json);
        String account = jsonObject.getString("account");
        String oldpwd = jsonObject.getString("oldpassword");
        String newpwd = jsonObject.getString("newpassword");
        boolean updatepwd = userservice.updatepwd(account, Password.jiami(oldpwd), Password.jiami(newpwd));
        RestResponse response = new RestResponse();
        if (updatepwd) {
            response.setCode(200);
            response.setMessage("账户:" + account + "修改成功");
            response.setData(updatepwd);
        } else {
            response.setCode(500);
            response.setMessage("账户:" + account + "修改失败");
            response.setData(updatepwd);
        }
        return JSON.toJSONString(response);
    }

    /**
     * 用户修改个人资料
     *
     * @param request
     * @return
     * @throws IOException
     */
    @UserLoginToken
    @RequestMapping(value = "/alertuser", method = RequestMethod.POST)
    @ResponseBody
    public String alertuser(HttpServletRequest request) throws IOException {
        jiexiJSON jiexiJSON = new jiexiJSON();
        String json = jiexiJSON.jiexi(request);
        JSONObject jsonObject = JSON.parseObject(json);
        String name = jsonObject.getString("name");
        String sex = jsonObject.getString("sex");
        String account = jsonObject.getString("account");
        boolean state = userservice.updateuser(account, name, Integer.valueOf(sex));
        RestResponse response = new RestResponse();
        if (state) {
            response.setCode(200);
            response.setMessage("账户:" + account + "修改成功");
            response.setData(state);
        } else {
            response.setCode(500);
            response.setMessage("账户:" + account + "修改失败");
            response.setData(state);
        }
        return JSON.toJSONString(response);
    }


}
