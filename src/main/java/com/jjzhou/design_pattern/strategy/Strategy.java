package com.jjzhou.design_pattern.strategy;

/**
 * @author jjzhou
 * @date 2020/11/23 9:09 下午
 * @description 创建一个接口
 */
public interface Strategy {

    /**
     * 执行操作
     * @param num1
     * @param num2
     * @return
     */
    int doOperation(int num1, int num2);
}
