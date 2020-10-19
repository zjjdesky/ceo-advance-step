package com.jjzhou.netty.project.req_and_resp.common;

/**
 * @author jjzhou
 * @date 2020/10/18 10:38 下午
 * @description 请求消息
 */
public class ReqMessage extends Message<Operation>{

    public ReqMessage() {
    }

    public ReqMessage(Long streamId, Operation operation) {
        MessageHeader messageHeader = new MessageHeader();
        messageHeader.setOpCode(OperationType.fromOperation(operation).getOpCode());
        messageHeader.setStreamId(streamId);

        this.setMessageHeader(messageHeader);
        this.setMessageBody(operation);
    }


    @Override
    public Class getMessageBodyDecodeClass(int opcode) {
        return OperationType.fromOpCode(opcode).getOperationClazz();
    }
}
