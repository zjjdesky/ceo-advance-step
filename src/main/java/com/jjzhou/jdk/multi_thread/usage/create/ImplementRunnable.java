package com.jjzhou.jdk.multi_thread.usage.create;

/**
 * @author jjzhou
 * @date 2020/7/18 10:43 下午
 * @description
 */
public class ImplementRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " running~");
    }

    public static void main(String[] args) {
        ImplementRunnable ir = new ImplementRunnable();

        Thread thread1= new Thread(ir);
        thread1.setName("thread1");

        Thread thread2= new Thread(ir);
        thread2.setName("thread2");

        thread1.start();
        thread2.start();
    }
}
