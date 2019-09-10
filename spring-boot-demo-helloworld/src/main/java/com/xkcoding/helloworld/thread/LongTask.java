package com.xkcoding.helloworld.thread;

import java.util.concurrent.TimeUnit;

public class LongTask implements Runnable {
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("long task run...");
    }
}
