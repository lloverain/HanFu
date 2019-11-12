package com.yangjiaying.hanfu.modular.login.entity;

/**
 * 状态值
 * @PackageName:com.yangjiaying.hanfu.modular.login.entity
 * @ClassName:state
 * @author:yangjiaying
 * @date 2019/11/6 9:23
 */
public class state {
    private String code; //返回值。推荐200代表成功，500代表失败。也可自定义状态码
    private String content;//内容
    private String other;//其他信息

    public state() {
    }

    public state(String code, String content, String other) {
        this.code = code;
        this.content = content;
        this.other = other;
    }

    @Override
    public String toString() {
        return "state{" +
                "code='" + code + '\'' +
                ", content='" + content + '\'' +
                ", other='" + other + '\'' +
                '}';
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
