package com.ch.lesson.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 包装返回对象
 * @Auter: zytshijack
 */
public class ServiceResult {
    /**
     * 返回的信息
     */
    private String message;
    /**
     * 执行是否成功
     */
    private Boolean isSuccess;

    private Map<String,Object> data = new HashMap<String,Object>();

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public Map<String, Object> getData() {
        return data;
    }

    /**
     * 添加数据
     * @param key
     * @param value
     */
    public void addData(String key,Object value){
        data.put(key, value);
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public ServiceResult() {
    }

    public ServiceResult(String message, Boolean isSuccess) {
        this.message = message;
        this.isSuccess = isSuccess;
    }
}
