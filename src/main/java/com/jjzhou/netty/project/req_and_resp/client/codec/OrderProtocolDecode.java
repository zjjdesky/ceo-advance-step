package com.jjzhou.netty.project.req_and_resp.client.codec;

import com.jjzhou.netty.project.req_and_resp.common.ReqMessage;
import com.jjzhou.netty.project.req_and_resp.common.RespMessage;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

/**
 * @author jjzhou
 * @date 2020/10/18 11:14 下午
 * @description
 */
public class OrderProtocolDecode extends MessageToMessageDecoder<ByteBuf> {

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        RespMessage respMessage = new RespMessage();
        respMessage.decode(byteBuf);

        list.add(respMessage);
    }
}
