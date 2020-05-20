package me.hqj.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:
 * @author: huqijin
 * @date: 2020-05-19 19:56
 * @version: 1.0
 */
public class FIFOMutexTest {

    public static void main(String[] args){

        FIFOMutex fifoMutex = new FIFOMutex();

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        int count = 5;

        CountDownLatch countDownLatch = new CountDownLatch(5);

        while(count > 0){
            executorService.execute(()->{
                try{
                    countDownLatch.countDown();
                    System.out.println(Thread.currentThread().getId()+" is ready!");
                    countDownLatch.await();
                    fifoMutex.lock();
                }catch(InterruptedException e){
                    System.out.println(Thread.currentThread().getId()+" has been interrupted!");
                }

            });
            count--;
        }
        try{
            Thread.sleep(1000);
            fifoMutex.unLock();
            Thread.sleep(1000);
            fifoMutex.unLock();
            Thread.sleep(1000);
            fifoMutex.unLock();
            Thread.sleep(1000);
            fifoMutex.unLock();
            Thread.sleep(1000);
            fifoMutex.unLock();
        }catch(Exception e){
            System.out.println("unlock error! msg : "+e.getMessage() + ". cause : "+ e.getCause());
        }
        executorService.shutdown();
    }

}
