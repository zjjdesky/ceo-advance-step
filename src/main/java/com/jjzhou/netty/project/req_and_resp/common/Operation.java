package com.jjzhou.netty.project.req_and_resp.common;

/**
 * @author jjzhou
 * @date 2020/10/18 10:36 下午
 * @description
 */
public abstract class Operation extends MessageBody {

    public abstract OperationResult execute();

}
