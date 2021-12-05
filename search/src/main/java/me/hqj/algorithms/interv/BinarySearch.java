package me.hqj.algorithms.interv;

/**
 * DIDI终面有序数组二分查找
 * 单向有序数组，int a[] = {1, 2, 3, 5, 7, 9, 11, 12, 13, 14 , 15, 16};
 * 编写查找函数int search(int a[], int len, int target)，返回数组下标，没有的元素返回-1
 */
public class BinarySearch {

    public static int search(int[] arr, int target) {
        if (arr == null || arr.length ==0) {
            return -1;
        }

        return binarySearch(arr, target, 0, arr.length - 1);
    }

    /**
     * 非递归的二分查找
     * @param arr
     * @param target
     * @param low
     * @param high
     * @return
     */
    public static int binarySearch(int[] arr, int target, int low, int high) {

        while(high >= low) {
            int middle = low + (high - low) / 2;
            if(arr[middle] == target) {
                return middle;
            }

            if(arr[middle] > target) { // 左半边查找
                high = middle -1;
            } else if(arr[middle] < target) {// 右半边查找
                low = middle + 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找的递归算法
     * @param arr
     * @param target
     * @param low
     * @param high
     * @return
     */
    public static int recursiveBinarySearch(int[] arr, int target, int low, int high) {

        if(high < low) {
            return -1;
        }

        int middle = low + (high - low) / 2;

        if(arr[middle] == target) {
            return middle;
        }

        if(arr[middle] > target) { //查找左半边
            return recursiveBinarySearch(arr, target, low, middle -1);
        } else {//查找右半边
            return recursiveBinarySearch(arr, target, middle + 1, high);
        }
    }

}
