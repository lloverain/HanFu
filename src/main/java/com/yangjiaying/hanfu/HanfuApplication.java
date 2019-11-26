package com.yangjiaying.hanfu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 */

@SpringBootApplication
public class HanfuApplication {

    private static Logger logger = LoggerFactory.getLogger(HanfuApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(HanfuApplication.class, args);
        logger.info("运行成功");
    }
}
