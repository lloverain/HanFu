package com.yangjiaying.hanfu.modular.login.dao;

import com.yangjiaying.hanfu.modular.login.entity.user;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 登录注册dao
 */
@Mapper
public interface loginMapper {

    @Select("select * from users where account = #{account} and password = #{password}")
    List<user> selectuser(user user);//登录验证

    @Insert("insert into users(account,password,name,sex) values(#{account},#{password},#{name},#{sex})")
    int register(user user);

    @Select("select count(*) from users where account = #{account}")
    int selectaccount(@Param("account") String account);

    @Select("select * from users where id = #{id}")
    user findUserById(@Param("id") String userId);

    @Select("select * from users where account = #{account} and password = #{password}")
    user findoneuser(@Param("account")String account,@Param("password")String password);

}
