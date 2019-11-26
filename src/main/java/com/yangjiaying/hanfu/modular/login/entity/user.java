package com.yangjiaying.hanfu.modular.login.entity;

/**
 * 账户
 * @PackageName:com.yangjiaying.modular.entity
 * @ClassName:user
 * @author:yangjiaying
 * @date 2019/11/5 22:12
 */
public class user {
    private String id;
    private String account;//账户
    private String password;//密码
    private String name;//昵称
    private String sex;//性别

    public user() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public user(String id, String account, String password, String name, String sex) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.name = name;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "user{" +
                "id='" + id + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
