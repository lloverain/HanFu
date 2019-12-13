package com.yangjiaying.hanfu.modular.LostAndFound.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface releaseMapper {

    @Insert("insert into lostandfound(name,account,title,content,contact,place,imagename) values(#{name},#{account},#{title},#{content},#{contact},#{place},#{imagename})")
    boolean insertrelease(@Param("name") String name,@Param("account")String account,
                          @Param("title")String title,@Param("content")String content,
                          @Param("contact")String contact,@Param("place")String place,
                          @Param("imagename")String imagename);
}
