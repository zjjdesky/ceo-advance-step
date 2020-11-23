package com.jjzhou.design_pattern.strategy;

/**
 * @author jjzhou
 * @date 2020/11/23 9:10 下午
 * @description
 */
public class OperationSubtract implements Strategy {

    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}
