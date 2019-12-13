package com.yangjiaying.hanfu.modular.LostAndFound.service.Impl;

import com.yangjiaying.hanfu.modular.LostAndFound.dao.releaseMapper;
import com.yangjiaying.hanfu.modular.LostAndFound.service.releaseservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @PackageName:com.yangjiaying.hanfu.modular.LostAndFound.service.Impl
 * @ClassName:releaseserviceImpl
 * @author:yangjiaying
 * @date 2019/12/12 16:58
 */
@Service
public class releaseserviceImpl implements releaseservice {

    @Autowired
    private releaseMapper releaseMapper;

    @Override
    public boolean release(String name, String account, String title, String content, String contact, String place, String imagepath) {
        return releaseMapper.insertrelease(name, account, title, content, contact, place, imagepath);
    }
}
