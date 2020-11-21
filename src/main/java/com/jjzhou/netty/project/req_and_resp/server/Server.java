package com.jjzhou.netty.project.req_and_resp.server;

import com.jjzhou.netty.project.req_and_resp.server.codec.OrderFrameDecode;
import com.jjzhou.netty.project.req_and_resp.server.codec.OrderFrameEncoder;
import com.jjzhou.netty.project.req_and_resp.server.codec.OrderProtocolDecode;
import com.jjzhou.netty.project.req_and_resp.server.codec.OrderProtocolEncoder;
import com.jjzhou.netty.project.req_and_resp.server.handler.OrderServerProcessHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.concurrent.DefaultThreadFactory;

/**
 * @author jjzhou
 * @date 2020/10/18 10:59 下午
 * @description
 */
public class Server {

    public static void main(String[] args) throws Exception {

        EventLoopGroup bossGroup = new NioEventLoopGroup(1, new DefaultThreadFactory("boss"));
        EventLoopGroup workerGroup = new NioEventLoopGroup(1, new DefaultThreadFactory("worker"));

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .handler(new LoggingHandler(LogLevel.INFO))
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel channel) throws Exception {
                        ChannelPipeline pipeline = channel.pipeline();

                        pipeline.addLast(new OrderFrameDecode());
                        pipeline.addLast(new OrderFrameEncoder());
                        pipeline.addLast(new OrderProtocolEncoder());
                        pipeline.addLast(new OrderProtocolDecode());

                        pipeline.addLast(new OrderServerProcessHandler());

                        pipeline.addLast(new LoggingHandler(LogLevel.INFO));

                    }
                });

        ChannelFuture future = serverBootstrap.bind(8080).sync();

        future.channel().closeFuture().sync();

        bossGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();
    }
}
