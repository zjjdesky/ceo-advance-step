package com.jjzhou.netty.project.req_and_resp.client.codec;

import io.netty.handler.codec.LengthFieldPrepender;

/**
 * @author jjzhou
 * @date 2020/10/18 11:17 下午
 * @description
 */
public class OrderFrameEncoder extends LengthFieldPrepender {

    public OrderFrameEncoder() {
        super(2);
    }
}
