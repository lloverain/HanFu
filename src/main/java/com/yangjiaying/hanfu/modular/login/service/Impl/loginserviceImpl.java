package com.yangjiaying.hanfu.modular.login.service.Impl;

import com.yangjiaying.hanfu.modular.login.dao.loginMapper;
import com.yangjiaying.hanfu.modular.login.entity.user;
import com.yangjiaying.hanfu.modular.login.service.loginservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 登录注册实现类
 * @PackageName:com.yangjiaying.modular.service.Impl
 * @ClassName:loginserviceImpl
 * @author:yangjiaying
 * @date 2019/11/5 22:20
 */
@Service
public class loginserviceImpl implements loginservice {

    @Autowired
    private loginMapper loginMapper;

    @Override
    public List<user> selectuser(user user) {
        return loginMapper.selectuser(user);
    }

    @Override
    public int register(user user) {

        return loginMapper.register(user);
    }

    @Override
    public int selectaccount(String account) {
        return loginMapper.selectaccount(account);
    }

    @Override
    public user findUserById(String userId) {
        return loginMapper.findUserById(userId);
    }

    @Override
    public boolean updatepwd(String account, String oldpwd,String newpwd) {
        user user = loginMapper.findoneuser(account,oldpwd);
        try{
            System.out.println(user.toString());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        if(user!=null){
            boolean updatepwd = loginMapper.updatepassword(account,newpwd);
            return updatepwd;
        }
        return false;

    }
}
