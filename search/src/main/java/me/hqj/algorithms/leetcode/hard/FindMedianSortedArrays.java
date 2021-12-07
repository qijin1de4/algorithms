package me.hqj.algorithms.leetcode.hard;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n))
 *
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 */
public class FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1 != null && nums2 != null && nums1.length > 0 && nums2.length > 0) {
            return mergeSortSolution(nums1, nums2);
        }

        return 0.0;
    }

    /**
     * 通过归并排序合并数组的方法来求中位数
     *
     * 时间复杂度 nums1.length + nums2.length
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double mergeSortSolution(int[] nums1, int[] nums2) {

        int l = nums1.length + nums2.length;

        int[] merged = new int[l];

        int i=0, j=0, k=0;

        while( k < l ) {

            if( i >= nums1.length) {
                while(j < nums2.length) { //nums1已经全部比较完了，直接将nums2全部拼接到merged即可
                    merged[k++] = nums2[j++];
                }
                break;
            }

            if(j >= nums2.length) {
                while(i < nums1.length) { //nums2已经全部比较完了，直接将nums2全部拼接到merged即可
                    merged[k++] = nums1[i++];
                }
                break;
            }

            if(nums1[i] <= nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }

        if(l % 2 == 0) { //合并后数组长度为偶数
            double high = merged[l/2];
            double low = merged[l/2 -1];
            return  (low + high) / 2;
        } else {
            return merged[l/2];
        }

    }
}
