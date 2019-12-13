package com.yangjiaying.hanfu.modular.LostAndFound.controller;

import com.alibaba.fastjson.JSON;
import com.yangjiaying.hanfu.modular.LostAndFound.entity.lostandfound;
import com.yangjiaying.hanfu.modular.LostAndFound.service.lostandfoundservice;
import com.yangjiaying.hanfu.modular.system.service.UserLoginToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @PackageName:com.yangjiaying.hanfu.modular.LostAndFound.controller
 * @ClassName:LostAndFound
 * @author:yangjiaying
 * @date 2019/12/13 12:16
 */
@Controller
@RequestMapping(value = "/API")
public class LostAndFoundControl {

    @Autowired
    private lostandfoundservice lostandfoundservice;

    @UserLoginToken
    @ResponseBody
    @RequestMapping(value = "/lostandfoundgetAll",method = RequestMethod.POST)
    public String lostandfound(){
        List<lostandfound> lostandfoundList = lostandfoundservice.selectAlllostandfound();;
        return JSON.toJSONString(lostandfoundList);
    }
}
