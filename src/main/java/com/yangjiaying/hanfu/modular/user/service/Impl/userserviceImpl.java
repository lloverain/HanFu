package com.yangjiaying.hanfu.modular.user.service.Impl;

import com.yangjiaying.hanfu.modular.login.dao.loginMapper;
import com.yangjiaying.hanfu.modular.login.entity.user;
import com.yangjiaying.hanfu.modular.user.dao.userMapper;
import com.yangjiaying.hanfu.modular.user.service.userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @PackageName:com.yangjiaying.hanfu.modular.user.service.Impl
 * @ClassName:userserviceImpl
 * @author:yangjiaying
 * @date 2019/12/11 18:06
 */
@Service
public class userserviceImpl implements userservice {

    @Autowired
    private userMapper userMapper;

    @Autowired
    private loginMapper loginMapper;

    @Override
    public boolean updatepwd(String account, String oldpwd, String newpwd) {
        user user = loginMapper.findoneuser(account, oldpwd);
        if (user != null) {
            boolean updatepwd = userMapper.updatepassword(account, newpwd);
            return updatepwd;
        }
        return false;
    }

    @Override
    public boolean updateuser(String account, String name, Integer sex) {
        boolean userstate = userMapper.updateuser(account, name, sex);
        if (userstate) {
            boolean lafstate = userMapper.updatelaf(account, name);
            if (lafstate) {
                return true;
            }
        }
        return false;
    }
}
