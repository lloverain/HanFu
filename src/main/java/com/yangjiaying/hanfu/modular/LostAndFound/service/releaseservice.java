package com.yangjiaying.hanfu.modular.LostAndFound.service;

import org.springframework.stereotype.Service;

@Service
public interface releaseservice {
    boolean release(String name,String account,String title,String content,
                    String contact,String place,String imagepath);
}
