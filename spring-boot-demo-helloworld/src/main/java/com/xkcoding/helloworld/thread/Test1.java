package com.xkcoding.helloworld.thread;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;


/**
 * 线程池方法
 * 1. void shutdown();  平滑地关闭线程池，已经提交到线程池中的任务会继续执行完
 *
 * 2. List<Runnable> shutdownNow();  立即关闭线程池，返回还没有开始执行的任务列表。会尝试中断正在执行的任务（每个线程调用 interruput方法），但这个行为不一定会成功。
 *
 * 3. boolean isShutdown(); 判断线程池是否已经关闭
 *
 * 4. boolean isTerminated(); 判断线程池的任务是否已经执行完毕。注意此方法调用之前需要先调用shutdown()方法或者shutdownNow()方法，否则总是会返回false
 *
 * 5. boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException;
 *      判断线程池的任务是否都执行完。如果没有任务没有执行完毕则阻塞，直至任务完成或者达到了指定的timeout时间就会返回
 *
 * 6. <T> Future<T> submit(Callable<T> task);
 *          提交带有一个返回值的任务到线程池中去执行（回调），返回的 Future 表示任务的待定结果。
 *            当任务成功完成后，通过 Future 实例的 get() 方法可以获取该任务的结果。Future 的 get() 方法是会阻塞的。
 *
 * 7.  <T> Future<T> submit(Runnable task, T result);
 *      提交一个Runnable的任务，当任务完成后，可以通过Future.get()获取的是提交时传递的参数T result
 *
 * 8. Future<?> submit(Runnable task);
 *          提交一个Runnable的人无语，它的Future.get()得不到任何内容，它返回值总是Null。
 *      为什么有这个方法？为什么不直接设计成void submit(Runnable task)这种方式？
 *        这是因为Future除了get这种获取任务信息外，还可以控制任务，
 *  具体体现在 Future的这个方法上：boolean cancel(boolean mayInterruptIfRunning)
 *  这个方法能够去取消提交的Rannable任务
 *
 *  9. <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException;
 *      执行一组给定的Callable任务，返回对应的Future列表。列表中每一个Future都将持有该任务的结果和状态。
 *  * 当所有任务执行完毕后，方法返回，此时并且每一个Future的isDone()方法都是true。
 *  * 完成的任务可能是正常结束，也可以是异常结束
 *  * 如果当任务执行过程中，tasks集合被修改了，那么方法的返回结果将是不确定的，
 *  即不能确定执行的是修改前的任务，还是修改后的任务
 *
 *  10.
 *
 */
public class Test1 {

    public static void main1(String[] args) {
        ExecutorService executor  = Executors.newFixedThreadPool(10);
        executor.submit(new LongTask());
        executor.submit(new LongTask());
        executor.submit(new ShortTask());
        executor.submit(new ShortTask());
        executor.shutdown();

        boolean shutdown = executor.isShutdown();
        System.out.println("线程池是否已经关闭：" + shutdown);

        final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        try{
            while (!executor.awaitTermination(1L, TimeUnit.SECONDS)) {
                System.out.println("线程池中还有任务在执行，当前时间：" + sdf.format(new Date()));
            }
            System.out.println("线程池中已经没有在执行的任务，线程池已完全关闭！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService executor  = Executors.newFixedThreadPool(10);
        executor.submit(new LongTask());
        executor.submit(new LongTask());
        executor.submit(new LongTask());
        executor.submit(new LongTask());
        List<Runnable> tasks =  executor.shutdownNow();

        try {
            TimeUnit.SECONDS.sleep(1L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(executor.isShutdown());
        System.out.println(tasks.size());
        if(tasks != null && tasks.size() > 0){
            for (Runnable task : tasks) {
                System.out.println(task.toString());
            }
        }
    }






}
