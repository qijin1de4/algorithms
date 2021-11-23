package me.hqj.algorithms.interv;

/**
 * DIDI终面有序数组二分查找
 * 单向有序数组，int a[] = {1, 2, 3, 5, 7, 9, 11, 12, 13, 14 , 15, 16};
 * 编写查找函数int search(int a[], int len, int target)，返回数组下标，没有的元素返回-1
 */
public class BinarSearchOnOrderedArray {

    public static int search(int[] arr, int target) {
        if (arr == null || arr.length ==0) {
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;
        int n = (end - start)/2;

        while(n - start > 0) {
            if(arr[n] == target) {
                return n;
            }
            if(target > arr[n]) {
                start = n+1;
            } else {
                end = n - 1;
            }
            n = (end - start)/2 + start;
        }

        if(arr[start]  == target) {
            return start;
        }
        if(arr[end]  == target) {
            return end;
        }
        return -1;
    }


}
