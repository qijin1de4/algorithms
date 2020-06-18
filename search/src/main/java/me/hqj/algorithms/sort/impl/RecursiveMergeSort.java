package me.hqj.algorithms.sort.impl;

import me.hqj.algorithms.sort.Sort;
import org.apache.commons.lang3.ArrayUtils;

/**
 *
 * 各种排序算法的java实现
 * https://www.cnblogs.com/onepixel/articles/7674659.html
 * @description: 归并排序
 * @author: huqijin
 * @date: 2020-06-08 18:35
 * @version: 1.0
 */
public class RecursiveMergeSort implements Sort {

    @Override
    public int[] sort(int[] arr) {
        return mergeSort(arr);
    }

    /**
     * 归并排序
     * @return
     */
    public int[] mergeSort(int[] arr){
       if(arr.length < 2){
           return arr;
       }
       int middle = arr.length /2;

       int[] left = ArrayUtils.subarray(arr, 0, middle);
       int[] right = ArrayUtils.subarray(arr, middle, arr.length);
       return Sort.merge(mergeSort(left), mergeSort(right));
    }

}
