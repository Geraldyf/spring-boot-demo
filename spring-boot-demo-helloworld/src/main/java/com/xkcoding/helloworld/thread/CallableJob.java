package com.xkcoding.helloworld.thread;

import java.util.concurrent.Callable;

public class CallableJob implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "success";
    }
}
