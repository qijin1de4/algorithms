package me.hqj.algorithms.sort.impl;

import me.hqj.algorithms.sort.Sort;
import org.apache.commons.lang3.ArrayUtils;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @description: 归并排序
 * @author: huqijin
 * @date: 2020-06-18 01:37
 * @version: 1.0
 */
public class ForkJoinMergeSort implements Sort {

    private ForkJoinPool forkJoinPool = new ForkJoinPool();

    @Override
    public int[] sort(int[] arr) {
        return forkJoinPool.invoke(new Task(arr));
    }

    private static class Task extends RecursiveTask<int[]> {

        private int[] arr;

        Task(int[] arr){
            this.arr = arr;
        }

        @Override
        protected int[] compute() {
            if(arr.length < 2){
                return arr;
            }else{
                int middle = arr.length / 2;
                int[] leftArr = ArrayUtils.subarray(arr, 0, middle);
                int[] rightArr = ArrayUtils.subarray(arr, middle, arr.length);
                Task leftTask = new Task(leftArr);
                Task rightTask = new Task(rightArr);
                leftTask.fork();
                rightTask.fork();
                int[] leftJoin = leftTask.join();
                int[] rightJoin = rightTask.join();

                return Sort.merge(leftJoin, rightJoin);
            }
        }
    }

}
