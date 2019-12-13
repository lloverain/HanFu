package com.yangjiaying.hanfu.modular.system.service.Impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.yangjiaying.hanfu.modular.login.entity.user;
import com.yangjiaying.hanfu.modular.system.config.systemConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import java.util.Date;

/**
 * 生成token
 * @PackageName:com.yangjiaying.hanfu.modular.system.service.Impl
 * @ClassName:getToken
 * @author:yangjiaying
 * @date 2019/11/25 22:36
 */
public class TokenUtil {
    public String getToken(user user) {
        Algorithm key = Algorithm.HMAC256(user.getPassword());
        Long now = System.currentTimeMillis();
        Long nexttime = now + systemConfig.PRESCRIPTIONTIME;
        Date nextDate = new Date(nexttime);
        System.out.println("nextDate:"+nextDate);
        String token = "";
        token = JWT.create()
                .withAudience(user.getId())
                .withExpiresAt(nextDate)
                .sign(key);
        return token;
    }
}
