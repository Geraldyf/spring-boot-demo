package com.xkcoding.helloworld.thread;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test2 {

    public static void main(String[] args) {

        ExecutorService threadpool = Executors.newFixedThreadPool(3);


        final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");



        List<Future<String>> futureList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            System.out.println("提交一个callable任务到线程池，现在时间是：" + sdf.format(new Date()));
            futureList.add(threadpool.submit(new CallableTask()));
        }


        try {
            for (Future<String> future : futureList) {
                System.out.println("获取callable任务的结果：" + future.get() + "，现在时间是：" + sdf.format(new Date()));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            if(threadpool!=null){
                threadpool.shutdown();
            }
        }
    }
}
