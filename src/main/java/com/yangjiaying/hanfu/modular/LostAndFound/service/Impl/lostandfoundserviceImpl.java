package com.yangjiaying.hanfu.modular.LostAndFound.service.Impl;

import com.yangjiaying.hanfu.modular.LostAndFound.dao.lostandfoundMapper;
import com.yangjiaying.hanfu.modular.LostAndFound.entity.lostandfound;
import com.yangjiaying.hanfu.modular.LostAndFound.service.lostandfoundservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @PackageName:com.yangjiaying.hanfu.modular.LostAndFound.service.Impl
 * @ClassName:lostandfoundserviceImpl
 * @author:yangjiaying
 * @date 2019/12/13 12:26
 */
@Service
public class lostandfoundserviceImpl implements lostandfoundservice {

    @Autowired
    private lostandfoundMapper lostandfoundMapper;

    @Override
    public List<lostandfound> selectAlllostandfound() {

        return lostandfoundMapper.selectAlllostandfound();
    }
}
