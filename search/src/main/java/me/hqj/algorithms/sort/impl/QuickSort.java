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
            quickSort(arr, 0, arr.length-1);
        }
        return arr;
    }

    private void quickSort(int[] arr, int start, int end){
        int i = start;
        int j = end;
        int pivot = arr[start];
        while(i < j) {
            //将<pivot的都放在pivot的左边的，>pivot的都放到pivot的右边
            while((i < j) && (arr[i] < pivot)) {
                i++;
            }
            while((i<j) && (arr[j] > pivot)) {
                j--;
            }
            if(arr[i] == arr[j]) {
                i++;
            } else {
                Sort.swap(arr, i, j);
            }
        }
        if(i -1 > start) quickSort(arr, start, i - 1);
        if(j + 1 < end) quickSort(arr, j+1, end);
    }

}
