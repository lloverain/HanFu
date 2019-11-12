package com.yangjiaying.hanfu.modular.homepage.entity;

/**
 * 这是我自己的，你们可以删除
 * @PackageName:com.yangjiaying.hanfu.modular.homepage.entity
 * @ClassName:xiaoshuo
 * @author:yangjiaying
 * @date 2019/11/8 0:39
 */
public class xiaoshuo {
    private String name;
    private String url;
    private String jianjie;

    @Override
    public String toString() {
        return "xiaoshuo{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", jianjie='" + jianjie + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getJianjie() {
        return jianjie;
    }

    public void setJianjie(String jianjie) {
        this.jianjie = jianjie;
    }
}
