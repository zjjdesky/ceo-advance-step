package com.jjzhou.design_pattern.proxy.jdk;

/**
 * @author jjzhou
 * @date 2021/1/4 5:20 下午
 * @description
 */
public class Main {

    public static void main(String[] args) {
        JdkMatchmaker jdkMatchmaker = new JdkMatchmaker();
        Person person = (Person) jdkMatchmaker.getInstance(new Customer());
        person.findLove();
    }
}
