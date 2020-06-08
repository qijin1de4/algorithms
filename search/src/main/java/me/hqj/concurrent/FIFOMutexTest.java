package me.hqj.concurrent;

import java.net.InetAddress;
import java.util.Locale;
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

        int TASKS = 200;


        FIFOMutex fifoMutex = new FIFOMutex();

        ExecutorService executorService = Executors.newFixedThreadPool(TASKS);

        int count = TASKS;

        CountDownLatch countDownLatch = new CountDownLatch(TASKS);

        while(count > 0){
            executorService.execute(()->{
                try{
                    countDownLatch.countDown();
                    System.out.println(Thread.currentThread().getId()+" is ready!");
                    System.out.println( Locale.CHINESE.getLanguage());
                    countDownLatch.await();
                    fifoMutex.lock();
                }catch(InterruptedException e){
                    System.out.println(Thread.currentThread().getId()+" has been interrupted!");
                }

            });
            count--;
        }
        try{
            InetAddress inetAddress = InetAddress.getLocalHost();
            System.out.println("IP Address:- " + inetAddress.getHostAddress());
            System.out.println("Host Name:- " + inetAddress.getHostName());

            for(int i = 0; i < TASKS; i++){
                Thread.sleep(5000);
                fifoMutex.unLock();
            }
        }catch(Exception e){
            System.out.println("unlock error! msg : "+e.getMessage() + ". cause : "+ e.getCause());
        }
        executorService.shutdown();
    }

}
