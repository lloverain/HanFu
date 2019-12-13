package com.yangjiaying.hanfu.modular.LostAndFound.service;

import com.yangjiaying.hanfu.modular.LostAndFound.entity.lostandfound;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface lostandfoundservice {

    List<lostandfound> selectAlllostandfound();

}
