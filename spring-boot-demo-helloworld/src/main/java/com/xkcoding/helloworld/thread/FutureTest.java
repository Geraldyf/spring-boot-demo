package com.xkcoding.helloworld.thread;

import java.util.concurrent.*;

public class FutureTest {


    public static void main(String[] args) throws Exception {
        functionTimeoutTest3();
    }

    public static void functionTimeoutTest2() throws Exception{

        ExecutorService executorService= Executors.newSingleThreadExecutor();

        Future<String> future = executorService.submit(()->
            {
                Thread.sleep(10000);
                return "success";
            }
        );

        try{
            String result = future.get(5, TimeUnit.SECONDS);
            //String result=future.get(50,TimeUnit.SECONDS);
            System.out.println("result:"+result);
        }
        catch (TimeoutException e){
            System.out.println("超时了!");
        }
    }



    private static void functionTimeoutTest3() throws Exception{
        ExecutorService executorService= Executors.newSingleThreadExecutor();

        FutureTask<String> future = new FutureTask<>(()->
        {
            Thread.sleep(10000);
            return "success";
        }
        );
        executorService.execute(future);

        try{
            String result=future.get(5,TimeUnit.SECONDS);
            //String result=future.get(50,TimeUnit.SECONDS);
            System.out.println("result:"+result);
        }
        catch (TimeoutException e){
            System.out.println("超时了!");
        }
    }

}
