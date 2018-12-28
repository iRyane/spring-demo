package com.springboot.common.utils;





import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author :yan
 * @Date :Create in 12/24/18
 * @Description :返回数据
 */

public class ResponseBo extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public ResponseBo() {
        put("code", ExceptionConstant.HTTP_REQUEST_SERVER_OK);
        put("msg", ExceptionConstant.getName(ExceptionConstant.HTTP_REQUEST_SERVER_OK));
    }

    public static ResponseBo  error() {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
    }

    public static ResponseBo error(String msg) {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
    }

    public static ResponseBo  error(int code, String msg) {
        ResponseBo r = new ResponseBo();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static ResponseBo ok(String msg) {
        ResponseBo r = new ResponseBo();
        r.put("msg", msg);
        return r;
    }

    public static ResponseBo  ok(Map<String, Object> map) {
        ResponseBo  r = new ResponseBo();
        r.putAll(map);
        return r;
    }

    public static ResponseBo  ok() {
        return new ResponseBo ();
    }

    public ResponseBo  put(String key, Object value) {
        super.put(key, value);
        return this;
    }

}
