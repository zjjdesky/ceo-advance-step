package com.jjzhou.netty.project.req_and_resp.util;

import com.google.gson.Gson;

/**
 * @author jjzhou
 * @date 2020/10/18 10:25 下午
 * @description
 */
public class JsonUtil {

    private static final Gson GSON = new Gson();

    private JsonUtil () {

    }

    public static <T> T fromJson(String jsonStr, Class<T> clazz) {
        return GSON.fromJson(jsonStr, clazz);
    }

    public static String toJson(Object object) {
        return GSON.toJson(object);
    }

}
