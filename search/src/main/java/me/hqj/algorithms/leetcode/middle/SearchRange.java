package me.hqj.algorithms.leetcode.middle;

import me.hqj.algorithms.interv.BinarySearch;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 *
 * 进阶：
 *
 * 你可以设计并实现时间复杂度为O(log n)的算法解决此问题吗？

 *
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[] {-1, -1};
        if(nums != null && nums.length > 0) {
            result[0] = searchLowerBound(nums, target, 0, nums.length -1);
            result[1] = searchUpperBound(nums, target, 0, nums.length -1);
        }
        return  result;
    }

    /**
     * 查找目标数组的下边界
     * @param nums
     * @param target
     * @param low
     * @param high
     * @return
     */
    private int searchLowerBound(int[] nums, int target, int low, int high) {

        if(high < low) {
            return -1;
        }

        int middle = low + (high - low) / 2;

        if(nums[middle] == target && (middle == 0 || nums[middle - 1] < target)) {
            return middle;
        }

        if (nums[middle] < target) {//右半边搜索
            return searchLowerBound(nums, target, middle + 1, high);
        } else {
            return searchLowerBound(nums, target, low, middle -1);
        }
    }

    /**
     * 查找数组的上边界
     * @param nums
     * @param target
     * @param low
     * @param high
     * @return
     */
    private int searchUpperBound(int[] nums, int target, int low, int high) {

        if(high < low) {
            return -1;
        }

        int middle = low + (high - low) / 2;

        if(nums[middle] == target && ( middle + 1 >= nums.length || nums[middle + 1] > target)) {
            return middle;
        }

        if(nums[middle] > target) { //左半边搜索
            return searchUpperBound(nums, target, low, middle - 1);
        }else {
            return searchUpperBound(nums, target, middle + 1, high);
        }
    }

    /**
     * 初始版本，时间复杂度较高
     * @param nums
     * @param target
     * @return
     */
    public int[] hqjSearchRange(int[] nums, int target) {

        int[] result = new int[] {-1, -1};

        if(nums != null && nums.length > 0 ) {
            int foundAt = BinarySearch.binarySearch(nums, target, 0, nums.length -1);
            if(foundAt >= 0) {
                result = new int[] {foundAt, foundAt};
                int start = foundAt;
                int end = foundAt;
                while(--start >= 0) {
                    if(nums[start] == target) {
                        result[0] = start;
                    }
                }
                while(++end < nums.length) {
                    if(nums[end] == target) {
                        result[1] = end;
                    }
                }
            }
        }
        return result;
    }
}
