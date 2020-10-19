package com.jjzhou.netty.project.req_and_resp.common;

import lombok.Data;

/**
 * @author jjzhou
 * @date 2020/10/18 10:27 下午
 * @description
 */
@Data
public class MessageHeader {

    /**
     * 版本
     */
    private int version = 1;

    /**
     * 操作码
     */
    private int opCode;

    /**
     * 流id 用于客户端获取结果
     */
    private long streamId;
}
