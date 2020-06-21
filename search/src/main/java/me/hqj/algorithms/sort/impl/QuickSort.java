package me.hqj.algorithms.sort.impl;

import me.hqj.algorithms.sort.Sort;
import org.apache.commons.lang3.ArrayUtils;

/**
 * @description: 快速排序
 * @author: huqijin
 * @date: 2020-06-21 07:11
 * @version: 1.0
 */
public class QuickSort implements Sort {
    @Override
    public int[] sort(int[] arr) {
        if(ArrayUtils.isNotEmpty(arr)){
            quickSort(arr, 0, arr.length);
        }
        return arr;
    }

    private void quickSort(int[] arr, int left, int right){
        if(left > 0 && left < right){
            int partition = partition(arr, left, right);
            if(partition > 0){
                quickSort(arr, left, partition);
                quickSort(arr, partition-1, right);
            }
        }
    }

    private int partition(int[] arr, int left, int right){
        int pivot = left;
        int index = left + 1;
        for( int i = index; i < right ; i++){
            if( arr[i] > arr[pivot] ){
                Sort.swap(arr, i, index);
                index++;
            }
        }
        Sort.swap(arr, pivot, --index);
        return index;
    }
}
