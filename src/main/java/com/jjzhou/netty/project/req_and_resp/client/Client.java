package com.jjzhou.netty.project.req_and_resp.client;

import com.jjzhou.netty.project.req_and_resp.client.codec.OrderFrameDecode;
import com.jjzhou.netty.project.req_and_resp.client.codec.OrderFrameEncoder;
import com.jjzhou.netty.project.req_and_resp.client.codec.OrderProtocolDecode;
import com.jjzhou.netty.project.req_and_resp.client.codec.OrderProtocolEncoder;
import com.jjzhou.netty.project.req_and_resp.common.ReqMessage;
import com.jjzhou.netty.project.req_and_resp.common.order.OrderOperation;
import com.jjzhou.netty.project.req_and_resp.util.IdUtil;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.concurrent.DefaultThreadFactory;

/**
 * @author jjzhou
 * @date 2020/10/18 10:59 下午
 * @description
 */
public class Client {

    public static void main(String[] args) throws Exception {

        EventLoopGroup bossGroup = new NioEventLoopGroup(1, new DefaultThreadFactory("boss"));

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(bossGroup)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel channel) throws Exception {
                        ChannelPipeline pipeline = channel.pipeline();
                        pipeline.addLast(new OrderFrameDecode());
                        pipeline.addLast(new OrderFrameEncoder());
                        pipeline.addLast(new OrderProtocolEncoder());
                        pipeline.addLast(new OrderProtocolDecode());
                        pipeline.addLast(new LoggingHandler(LogLevel.INFO));
                    }
                });

        ChannelFuture future = bootstrap.connect("127.0.0.1", 8080);

        future.sync();
        // 请求
        ReqMessage reqMessage = new ReqMessage(IdUtil.nextId(), new OrderOperation(1001, "tudou"));
        future.channel().writeAndFlush(reqMessage);

        future.channel().closeFuture().sync();

        bossGroup.shutdownGracefully();
    }
}
