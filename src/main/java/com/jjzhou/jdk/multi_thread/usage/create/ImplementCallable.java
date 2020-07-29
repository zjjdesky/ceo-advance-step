package com.jjzhou.jdk.multi_thread.usage.create;

import java.util.concurrent.*;

/**
 * @author jjzhou
 * @date 2020/7/18 10:54 下午
 * @description
 */
public class ImplementCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        return Thread.currentThread().getName() + " is running~";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ImplementCallable ic = new ImplementCallable();
        // 创建固定大小为1的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        // 将任务添加到线程池
        Future<String> future = executorService.submit(ic);
        // 以阻塞的方式获取结果
        System.out.println(future.get());
        // 关闭线程池
        executorService.shutdown();
    }
}
