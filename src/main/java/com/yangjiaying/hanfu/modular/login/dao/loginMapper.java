package com.yangjiaying.hanfu.modular.login.dao;

import com.yangjiaying.hanfu.modular.login.entity.user;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 登录注册dao
 */
@Mapper
public interface loginMapper {

    @Select("select * from users where account = #{account} and password = #{password}")
    List<user> selectuser(user user);//验证扥估

    @Insert("insert into users(account,password,name,sex) values(#{account},#{password},#{name},#{sex})")
    int register(user user);

    @Select({"select count(*) from users where account = #{account}"})
    int selectaccount(@Param("account") String account);
}
