package com.yangjiaying.hanfu.modular.user.service;

import org.springframework.stereotype.Service;

/**
 * @PackageName:com.yangjiaying.hanfu.modular.user.service
 * @ClassName:userservice
 * @author:yangjiaying
 * @date 2019/12/11 18:05
 */
@Service
public interface userservice {

    boolean updatepwd(String account,String oldpwd,String newpwd);//更新用户密码

    boolean updateuser(String account,String name,Integer sex);

}
