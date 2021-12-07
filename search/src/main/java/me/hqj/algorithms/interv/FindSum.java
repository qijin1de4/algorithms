package me.hqj.algorithms.interv;

/**
 * 美团二面
 *
 * 给定一个单调有序的整数数组，查找满足和等于sum的两个数组元素的下标。
 *
 * 如果没有返回 {-1，-1}
 *
 * [2,3,5,7] , sum = 10, 返回 {1,3}
 *
 *
 */
public class FindSum {

    public int[] findSum(int[] nums, int target) {
        int[] result = new int[] {-1, -1};
        if(nums != null && nums.length > 0) {
            for(int i = 0; i < nums.length; i++) {
                if(target - nums[i] >= 0) {
                    int pos = binarySearch(nums, target - nums[i], i + 1, nums.length -1 );
                    if(pos >= 0) {
                        result[0] = i;
                        result[1] = pos;
                        return result;
                    }
                }
            }
        }
        return result;
    }

    private int binarySearch(int[] arr, int target, int low ,int high) {

        if(high < low) {
            return -1;
        }

        int middle = low + (high - low) / 2;

        if(arr[middle] == target) {
            return middle;
        }

        if(arr[middle] < target) {
            return binarySearch(arr, target, middle+1, high);
        } else {
            return binarySearch(arr, target, low, middle - 1);
        }

    }

}
