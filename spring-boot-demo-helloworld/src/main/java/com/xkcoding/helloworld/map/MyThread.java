package com.xkcoding.helloworld.map;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThread implements Runnable{

    /**
     * 共享对象
     */
    static Map<String, Integer> hashMap = new HashMap<>();

    /**
     * 线程ID
     */
    private int id;

    public MyThread(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            hashMap.put("id",id);
        }
    }

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            threadPool.submit(new MyThread(i));
        }
        while (true){
            System.out.println(hashMap.get("id"));
        }

    }
}















