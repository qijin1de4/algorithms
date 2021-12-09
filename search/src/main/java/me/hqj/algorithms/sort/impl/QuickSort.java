package me.hqj.algorithms.sort.impl;

import me.hqj.algorithms.sort.Sort;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Stack;

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
//            quickSort(arr, 0, arr.length-1);
//            nonRecursiveQuickSort(arr, 0, arr.length - 1);
            cnociseQuickSort(arr, 0, arr.length - 1);
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
            while((i < j) && (arr[j] > pivot)) {
                j--;
            }
            if(arr[i] == arr[j] && i < j) {
                i++;
            } else {
                Sort.swap(arr, i, j);
            }
        }
        if(i - 1 > start) quickSort(arr, start, i - 1);
        if(j + 1 < end) quickSort(arr, j+1, end);
    }



    /**
     * 快速排序的非递归实现
     * @param arr
     * @param start
     * @param end
     */
    private void nonRecursiveQuickSort(int[] arr, int start, int end) {

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] {start, end});

        while(!stack.empty()) {
            int[] param = stack.pop();
            int i = param[0]; // start
            int j = param[1]; // end
            int pivot = arr[param[0]]; // 作为排序中间值
            while(i < j) {
                while( i < j && arr[i] < pivot) {
                    i++;
                }
                while( i < j && arr[j] > pivot) {
                    j--;
                }
                if(arr[i] == arr[j] && i < j) {
                    i++;
                } else {
                    Sort.swap(arr, i, j);
                }
            }
            if( i - 1 > param[0]) {
                stack.push(new int[] {param[0], i - 1});
            }
            if(j + 1 < param[1]) {
                stack.push(new int[] {j+1, param[1]});
            }
        }
    }


    /**
     * partition过程中仅使用一个loop的简洁版的快速排序
     * @param nums
     * @param low
     * @param high
     */
    private void cnociseQuickSort(int[] nums, int low, int high) {
        if(low < high) {

            int pivotIndex = partition(nums, low, high);

            cnociseQuickSort(nums, low, pivotIndex - 1);
            cnociseQuickSort(nums, pivotIndex + 1, high);
        }

    }

    /**
     * 使用单指针的分区方法
     * @param nums
     * @param low
     * @param high
     * @return
     */
    private int partition(int[] nums, int low, int high) {

        int index = low+1;
        for(int i = low+1; i <= high; i++) {
            if(nums[i] < nums[low]) {
                Sort.swap(nums, i, index++);
            }
        }
        Sort.swap(nums, low, index - 1);
        return index - 1;
    }
}
