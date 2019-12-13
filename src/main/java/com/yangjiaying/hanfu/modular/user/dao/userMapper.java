package com.yangjiaying.hanfu.modular.user.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface userMapper {

    @Update("update users set password = #{password} where account = #{account}")
    boolean updatepassword(@Param("account")String account, @Param("password") String password);

    @Update("update users set name = #{name},sex = #{sex} where account = #{account}")
    boolean updateuser(@Param("account")String account,@Param("name")String name,@Param("sex")Integer sex);

    @Update("update lostandfound set name =#{name} where account = #{account}")
    boolean updatelaf(@Param("account")String account,@Param("name")String name);

}
