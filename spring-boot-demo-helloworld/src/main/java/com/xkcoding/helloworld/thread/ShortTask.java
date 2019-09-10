package com.xkcoding.helloworld.thread;

public class ShortTask implements Runnable {
    @Override
    public void run() {
        System.out.println("short task run.........");
    }
}
