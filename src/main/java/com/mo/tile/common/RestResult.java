package com.mo.tile.common;
/**
 * api 接口返回结果封装
 *
 * @author Moyz
 * @date 2021/04/23 13:01
 */

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class RestResult {
    private String msg;
    private int code;
    private Object data;

    public RestResult() {

    }

    public RestResult(String msg, int code, Object data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public static RestResult newInstance() {
        return new RestResult();
    }

    public void put(String key, Object data) {
        if (this.data == null) {
            this.data = new HashMap<String, Object>();
        }
        ((Map) this.data).put(key, data);
    }

}

