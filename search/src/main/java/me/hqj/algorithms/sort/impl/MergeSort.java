package me.hqj.algorithms.sort.impl;

import me.hqj.algorithms.sort.Sort;
import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * 各种排序算法的java实现
 * https://www.cnblogs.com/onepixel/articles/7674659.html
 * @description:
 * @author: huqijin
 * @date: 2020-06-08 18:35
 * @version: 1.0
 */
public class MergeSort implements Sort {

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
       return merge(mergeSort(left), mergeSort(right));
    }

    private int[] merge(int[] left, int[] right){
        List<Integer> list = new ArrayList();
        int lIndex = 0, rIndex = 0;
        while(lIndex < left.length &&  rIndex < right.length){
            if(left[lIndex] <= right[rIndex]){
                list.add(left[lIndex]);
                lIndex ++;
            }else{
                list.add(right[rIndex]);
                rIndex ++;
            }
        }
        while (lIndex < left.length) {
            list.add(left[lIndex]);
            lIndex++;
        }
        while(rIndex < right.length){
            list.add(right[rIndex]);
            rIndex++;
        }
        int[] result = new int[list.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = list.get(i);
        }
        return result;
    }

}
