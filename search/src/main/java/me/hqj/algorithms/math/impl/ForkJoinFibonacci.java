package me.hqj.algorithms.math.impl;

import me.hqj.algorithms.math.Fibonacci;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @description:
 * @author: huqijin
 * @date: 2020-06-18 00:28
 * @version: 1.0
 */
public class ForkJoinFibonacci implements Fibonacci {

    private ForkJoinPool forkJoinPool = new ForkJoinPool();

    private static class Task extends RecursiveTask<Long> {

        long order;

        Task(long order){
            this.order = order;
        }

        @Override
        protected Long compute() {
            if(order - 2 > 0){
                Task leftTask= new Task(order - 1 );
                Task rightTask = new Task(order - 2);
                leftTask.fork();
                rightTask.fork();
                return leftTask.join() + rightTask.join();
            }else{
                return 1L;
            }
        }
    }

    @Override
    public long getNumber(long order) {
        Task task = new Task(order);
        return forkJoinPool.invoke(task);
    }

    @Override
    public long[] getSequence(int length) {
        long[] seqArr = new long[length];
        for(int i = 0; i < length; i++){
            seqArr[i] = getNumber(i+1);
        }
        return seqArr;
    }
}
