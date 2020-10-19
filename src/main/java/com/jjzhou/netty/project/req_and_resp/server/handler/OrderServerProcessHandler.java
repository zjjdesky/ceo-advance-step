package com.jjzhou.netty.project.req_and_resp.server.handler;

import com.jjzhou.netty.project.req_and_resp.common.Operation;
import com.jjzhou.netty.project.req_and_resp.common.OperationResult;
import com.jjzhou.netty.project.req_and_resp.common.ReqMessage;
import com.jjzhou.netty.project.req_and_resp.common.RespMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author jjzhou
 * @date 2020/10/18 11:20 下午
 * @description
 */
public class OrderServerProcessHandler extends SimpleChannelInboundHandler<ReqMessage> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ReqMessage reqMessage) throws Exception {
        Operation operation = reqMessage.getMessageBody();
        OperationResult operationResult = operation.execute();

        RespMessage respMessage = new RespMessage();
        respMessage.setMessageHeader(reqMessage.getMessageHeader());
        respMessage.setMessageBody(operationResult);

        if (channelHandlerContext.channel().isActive() &&
            channelHandlerContext.channel().isWritable()) {
            channelHandlerContext.writeAndFlush(respMessage);
        }
    }
}
