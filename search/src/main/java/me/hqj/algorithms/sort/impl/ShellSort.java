package me.hqj.algorithms.sort.impl;

import me.hqj.algorithms.sort.Sort;
import org.apache.commons.lang3.ArrayUtils;

/**
 * @description: 希尔排序
 * @author: huqijin
 * @date: 2020-06-20 18:54
 * @version: 1.0
 */
public class ShellSort implements Sort {
    @Override
    public int[] sort(int[] arr) {
        if(ArrayUtils.isNotEmpty(arr)){
            for(int gap = arr.length/2; gap > 0; gap /= 2 ){
                innerInsertionSrot(arr, gap);
            }
        }
        return arr;
    }

    public int[] sort(int[] arr, int[] gaps){
        if(ArrayUtils.isNotEmpty(arr) && ArrayUtils.isNotEmpty(gaps)){
            for(int gap : gaps){
                innerInsertionSrot(arr, gap);
            }
        }
        return arr;
    }

    private void innerInsertionSrot(int[] arr, int gap) {
        for(int i = gap; i < arr.length; i++){
            int j = i;
            int current = arr[j];
            while(j-gap >= 0 && arr[j-gap] > arr[j] ){
                 arr[j-gap] = arr[j];
                 j -= gap;
            }
            arr[j] = current;
         }
    }
}
