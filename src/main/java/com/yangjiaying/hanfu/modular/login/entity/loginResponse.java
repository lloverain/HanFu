package com.yangjiaying.hanfu.modular.login.entity;

/**
 * @PackageName:com.yangjiaying.hanfu.modular.login.entity
 * @ClassName:loginResponse
 * @author:yangjiaying
 * @date 2019/11/26 0:43
 * 登录之后返回的内容
 */
public class loginResponse {
    private String name;//昵称
    private String account;//账户
    private String sex;//性别
    private String token;//认证的token
    private String time;//提示账户的有效期

    @Override
    public String toString() {
        return "loginResponse{" +
                "name='" + name + '\'' +
                ", account='" + account + '\'' +
                ", sex='" + sex + '\'' +
                ", token='" + token + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
