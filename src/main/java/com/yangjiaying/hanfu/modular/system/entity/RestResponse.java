package com.yangjiaying.hanfu.modular.system.entity;

import com.alibaba.fastjson.JSON;

/**
 * @PackageName:com.yangjiaying.hanfu.modular.system.dao
 * @ClassName:RestResponse
 * @author:yangjiaying
 * @date 2019/11/26 0:29
 */
/**
 * @author Administrator
 * @DESCRIPTION 统一API响应结果封装
 */
public class RestResponse {
    private int code;
    private String message;
    private Object data;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
