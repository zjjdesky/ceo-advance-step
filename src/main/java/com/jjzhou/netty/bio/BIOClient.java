package com.jjzhou.netty.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.UUID;

/**
 * @author jjzhou
 * @date 2020/8/8 7:25 上午
 * @description
 */
public class BIOClient {

    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 8080);

        OutputStream os = client.getOutputStream();

        String name = UUID.randomUUID().toString();

        System.out.println("客户端发送数据：" + name);

        os.write(name.getBytes());
        os.close();
        client.close();

    }
}
