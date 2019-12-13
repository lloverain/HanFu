package com.yangjiaying.hanfu.modular.LostAndFound.entity;

import java.lang.annotation.Target;

/**
 * @PackageName:com.yangjiaying.hanfu.modular.LostAndFound.entity
 * @ClassName:lostandfound
 * @author:yangjiaying
 * @date 2019/12/13 12:20
 */
public class lostandfound {
    private int id;
    private String name;//发布人名称
    private String account;//发布人账户
    private String title;//标题
    private String content;//内容
    private String contact;//联系方式
    private String place;//地点
    private String imagename;//存储照片名称

    @Override
    public String toString() {
        return "lostandfound{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", account='" + account + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", contact='" + contact + '\'' +
                ", place='" + place + '\'' +
                ", imagename='" + imagename + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getImagename() {
        return imagename;
    }

    public void setImagename(String imagename) {
        this.imagename = imagename;
    }
}
