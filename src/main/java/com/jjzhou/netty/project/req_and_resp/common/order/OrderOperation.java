package com.jjzhou.netty.project.req_and_resp.common.order;

import com.jjzhou.netty.project.req_and_resp.common.Operation;
import com.jjzhou.netty.project.req_and_resp.common.OperationResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author jjzhou
 * @date 2020/10/18 10:50 下午
 * @description
 */
@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderOperation extends Operation {

    private Integer tableId;

    private String context;

    @Override
    public OperationResult execute() {
        log.info("order execute start ......");
        try {
            // 业务逻辑
            TimeUnit.SECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("order execute end ......");
        return new OrderOperationResult(tableId, context, true);
    }
}
