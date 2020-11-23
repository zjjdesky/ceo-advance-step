package com.jjzhou.design_pattern.strategy;

/**
 * @author jjzhou
 * @date 2020/11/23 9:12 下午
 * @description
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }
}
