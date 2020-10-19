package com.jjzhou.netty.project.req_and_resp.client.codec;

import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * @author jjzhou
 * @date 2020/10/18 11:09 下午
 * @description
 */
public class OrderFrameDecode extends LengthFieldBasedFrameDecoder {

    public OrderFrameDecode() {
        super(Integer.MAX_VALUE, 0, 2, 0, 2);
    }
}
