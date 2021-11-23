package me.hqj.algorithms.sort.impl;

import me.hqj.algorithms.sort.Sort;
import org.apache.commons.lang3.ArrayUtils;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * @description:
 * @author: huqijin
 * @date: 2020-06-21 18:23
 * @version: 1.0
 */
public class ForkJoinQuickSort implements Sort {

    private ForkJoinPool forkJoinPool = new ForkJoinPool();

    @Override
    public int[] sort(int[] arr) {
        if(ArrayUtils.isNotEmpty(arr)){
            forkJoinPool.invoke(new Task(arr, 0, arr.length));
        }
        return arr;
    }

    private static class Task extends RecursiveAction {
        private int[] arr;
        private int left;
        private int right;

        Task(int[] arr, int left, int right){
            this.arr = arr;
            this.left = left;
            this.right = right;
        }
        @Override
        protected void compute() {
            if(left > 0 && right - left > 0){
//                int partition = QuickSort.partition(arr, left, right);
//                if(partition > 0){
//                    Task leftTask = new Task(arr, left, partition);
//                    Task rightTask = new Task(arr, partition, right);
//                    leftTask.fork();
//                    rightTask.fork();
//                    leftTask.join();
//                    rightTask.join();
//                }
            }
        }
    }
}
