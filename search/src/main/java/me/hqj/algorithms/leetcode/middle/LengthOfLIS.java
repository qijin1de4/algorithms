package me.hqj.algorithms.leetcode.middle;

/**
 * 最长子序列
 *
 * 运用动态规划思想
 *
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 */
public class LengthOfLIS {

    int max = 1;

    //优化性能缓存
    Integer[] cache = null;

    public int lengthOfLIS(int[] nums) {
        this.max = 1;
        if( nums != null && nums.length > 0) {
            cache = new Integer[nums.length];
            lengthFromN(nums, nums.length);
            return max;
        }
        return 0;
    }

    private int lengthFromN(int[] arr, int n) {

        int tempMax = 1;

        if(n <= 1) {
            return n;
        }

        if(cache[n - 1] != null) {
            return cache[n-1];
        }

        for(int i = n - 1; i >= 1 ; i--) {
            int tempCount = lengthFromN(arr, i);
            if( arr[ i-1 ] < arr[n-1] && tempCount + 1 > tempMax) {
                tempMax = tempCount + 1;
            }
            if(tempMax > max) {
                max = tempMax;
            }
        }

        cache[n - 1] = tempMax;

        return tempMax;
    }

}
