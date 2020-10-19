package com.jjzhou.netty.project.req_and_resp.client.codec;

import com.jjzhou.netty.project.req_and_resp.common.ReqMessage;
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
public class OrderProtocolEncoder extends MessageToMessageEncoder<ReqMessage> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, ReqMessage reqMessage, List<Object> list) throws Exception {
        ByteBuf buffer = channelHandlerContext.alloc().buffer();
        reqMessage.encode(buffer);
        list.add(reqMessage);
    }
}
