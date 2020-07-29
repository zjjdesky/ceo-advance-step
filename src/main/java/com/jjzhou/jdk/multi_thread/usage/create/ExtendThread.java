package com.jjzhou.jdk.multi_thread.usage.create;

/**
 * @description 继承Thread类创建多线程
 * @author jjzhou
 * @date 2020/7/18 10:36 下午
 * @description
 */
public class ExtendThread extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " running~");
    }

    public static void main(String[] args) {
        ExtendThread et1 = new ExtendThread();
        et1.setName("thread-1");

        ExtendThread et2 = new ExtendThread();
        et2.setName("thread-2");

        et1.start();
        et2.start();
    }
}
