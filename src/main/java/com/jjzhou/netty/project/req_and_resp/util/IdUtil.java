package com.jjzhou.netty.project.req_and_resp.util;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author jjzhou
 * @date 2020/10/18 10:24 下午
 * @description
 */
public class IdUtil {

    private static final AtomicLong IDX = new AtomicLong();

    private IdUtil() {

    }

    public static long nextId() {
        return IDX.incrementAndGet();
    }
}
