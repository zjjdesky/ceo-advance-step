package com.jjzhou.netty.project.req_and_resp.common;

/**
 * @author jjzhou
 * @date 2020/10/18 10:38 下午
 * @description 响应消息
 */
public class RespMessage extends Message<OperationResult> {

    public RespMessage() {
    }

    @Override
    public Class getMessageBodyDecodeClass(int opcode) {
        return OperationType.fromOpCode(opcode).getOperationResultClazz();
    }
}
