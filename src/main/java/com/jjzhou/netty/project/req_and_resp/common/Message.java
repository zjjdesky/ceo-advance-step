package com.jjzhou.netty.project.req_and_resp.common;

import com.jjzhou.netty.project.req_and_resp.util.JsonUtil;
import io.netty.buffer.ByteBuf;
import lombok.Data;

import java.nio.charset.StandardCharsets;

/**
 * @author jjzhou
 * @date 2020/10/18 10:27 下午
 * @description
 */
@Data
public abstract class Message<T extends MessageBody> {

    /**
     * 消息头
     */
    private MessageHeader messageHeader;

    /**
     * 消息体
     */
    private T messageBody;

    /**
     * 编码
     * @param byteBuf
     */
    public void encode(ByteBuf byteBuf) {
        byteBuf.writeInt(messageHeader.getVersion());
        byteBuf.writeLong(messageHeader.getStreamId());
        byteBuf.writeInt(messageHeader.getOpCode());
        byteBuf.writeBytes(JsonUtil.toJson(messageBody).getBytes());
    }

    /**
     * 解码
     * @param msg
     */
    public void decode(ByteBuf msg) {
        MessageHeader messageHeader = new MessageHeader();
        messageHeader.setVersion(msg.readInt());
        messageHeader.setStreamId(msg.readLong());
        messageHeader.setOpCode(msg.readInt());

        this.messageHeader = messageHeader;

        Class<T> bodyClazz = getMessageBodyDecodeClass(messageHeader.getOpCode());
        this.messageBody = JsonUtil.fromJson(msg.toString(StandardCharsets.UTF_8), bodyClazz);
    }

    public abstract Class<T> getMessageBodyDecodeClass(int opcode);
}
