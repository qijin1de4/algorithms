package me.hqj.algorithms.sort.impl;

import me.hqj.algorithms.sort.Sort;
import org.apache.commons.lang3.ArrayUtils;

/**
 * @description: 插入排序
 * @author: huqijin
 * @date: 2020-06-18 17:09
 * @version: 1.0
 */
public class InsertionSort implements Sort {
    @Override
    public int[] sort(int[] arr) {
        if(ArrayUtils.isNotEmpty(arr)){
            for(int i = 0; i < arr.length; i++){
                int j = i;
                while(j > 0 ){
                    int previous = j-1;
                    if(arr[j] < arr[previous]){
                        Sort.swap(arr, j, previous);
                    }
                    j--;
                }
            }
        }
        return arr;
    }
}
