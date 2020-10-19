package com.jjzhou.netty.project.req_and_resp.common.order;

import com.jjzhou.netty.project.req_and_resp.common.OperationResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jjzhou
 * @date 2020/10/18 10:50 下午
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderOperationResult extends OperationResult {

    private Integer tableId;

    private String context;

    private Boolean isCompleted;
}
