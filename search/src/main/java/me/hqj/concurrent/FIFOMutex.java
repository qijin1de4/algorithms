package me.hqj.concurrent;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

/**
 * @description:
 * @author: huqijin
 * @date: 2020-05-19 19:58
 * @version: 1.0
 */
public class FIFOMutex {

    private final AtomicBoolean locked = new AtomicBoolean(false);

    private final Queue<Thread> waiters = new ConcurrentLinkedQueue<>();

    public void lock(){
        boolean wasInterrupted = false;
        Thread current = Thread.currentThread();
        waiters.add(current);

        while( current != waiters.peek() || !locked.compareAndSet(false, true)){
            System.out.println(current.getId()+" : enter waiting!");
            LockSupport.park();
            if(Thread.interrupted()){
                wasInterrupted = true;
            }
        }
        System.out.println(current.getId()+" : out waiting! Complete mission.");
        waiters.remove();
        if(wasInterrupted){
            current.interrupt();
        }
    }

    public void unLock(){
        locked.set(false);
        LockSupport.unpark(waiters.peek());
    }

}
