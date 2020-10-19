package com.jjzhou.netty.project.req_and_resp.common;

import com.jjzhou.netty.project.req_and_resp.common.order.OrderOperation;
import com.jjzhou.netty.project.req_and_resp.common.order.OrderOperationResult;

import java.util.function.Predicate;

/**
 * @author jjzhou
 * @date 2020/10/18 10:43 下午
 * @description
 */
public enum OperationType {

    ORDER(3, OrderOperation.class, OrderOperationResult.class);
    ;

    /**
     * 操作码
     */
    private Integer opCode;

    /**
     * 请求操作类
     */
    private Class<? extends Operation> operationClazz;

    /**
     * 返回结果类
     */
    private Class<? extends OperationResult> operationResultClazz;

    OperationType(Integer opCode, Class<? extends Operation> operationClazz, Class<? extends OperationResult> operationResultClazz) {
        this.opCode = opCode;
        this.operationClazz = operationClazz;
        this.operationResultClazz = operationResultClazz;
    }

    /**
     *
     * @param opCode
     * @return
     */
    public static OperationType fromOpCode(Integer opCode) {
        return getOperationType(opType -> opType.opCode.equals(opCode));
    }

    /**
     *
     * @param operation
     * @return
     */
    public static OperationType fromOperation(Operation operation) {
        return getOperationType(opType -> opType.operationClazz.equals(operation.getClass()));
    }

    private static OperationType getOperationType(Predicate<OperationType> predicate) {
        for (OperationType operationType : values()) {
            if (predicate.test(operationType)) {
                return operationType;
            }
        }
        throw new AssertionError("not found");
    }

    public Integer getOpCode() {
        return opCode;
    }

    public Class<? extends Operation> getOperationClazz() {
        return operationClazz;
    }

    public Class<? extends OperationResult> getOperationResultClazz() {
        return operationResultClazz;
    }
}
