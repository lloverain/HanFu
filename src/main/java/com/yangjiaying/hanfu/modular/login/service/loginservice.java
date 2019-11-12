package com.yangjiaying.hanfu.modular.login.service;

import com.yangjiaying.hanfu.modular.login.entity.user;

import java.util.List;

/**
 * 接口
 */
public interface loginservice {

    List<user> selectuser(user user); //登录

    int register(user user); //注册

    int selectaccount(String account);//检查账户是否已经注册
}
