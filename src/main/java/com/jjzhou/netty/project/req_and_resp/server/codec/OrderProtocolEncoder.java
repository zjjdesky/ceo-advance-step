package com.jjzhou.netty.project.req_and_resp.server.codec;

import com.jjzhou.netty.project.req_and_resp.common.RespMessage;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

/**
 * @author jjzhou
 * @date 2020/10/18 11:18 下午
 * @description
 */
public class OrderProtocolEncoder extends MessageToMessageEncoder<RespMessage> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, RespMessage respMessage, List<Object> list) throws Exception {
        ByteBuf buffer = channelHandlerContext.alloc().buffer();
        respMessage.encode(buffer);
        list.add(respMessage);
    }
}
