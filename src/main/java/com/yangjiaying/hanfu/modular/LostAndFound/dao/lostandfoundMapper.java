package com.yangjiaying.hanfu.modular.LostAndFound.dao;

import com.yangjiaying.hanfu.modular.LostAndFound.entity.lostandfound;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @PackageName:com.yangjiaying.hanfu.modular.LostAndFound.dao
 * @ClassName:lostandfoundMapper
 * @author:yangjiaying
 * @date 2019/12/13 12:19
 */
@Mapper
public interface lostandfoundMapper {
    @Select("select * from lostandfound")
    List<lostandfound> selectAlllostandfound();
}
