package me.hqj.algorithms.sort.impl;

import me.hqj.algorithms.sort.Sort;
import org.apache.commons.lang3.ArrayUtils;

/**
 * @description: 插入排序
 * 它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
 * 从下标0开始，通过向左两两比较，如果左边的元素比当前元素大就交换元素位置，直到左边的元素<=当前元素为止.
 * 因为是从下标0开始，左边的子序列一定是从小到大排好序的。
 * 所以for循环中的while循环中，只要左边元素小于当前元素就可以返回。
 * @author: huqijin
 * @date: 2020-06-18 17:09
 * @version: 1.0
 */
public class InsertionSort implements Sort {
    @Override
    public int[] sort(int[] arr) {
        if(ArrayUtils.isNotEmpty(arr)) {
            for(int i = 1; i < arr.length; i++) {
                int j = i;
                while(j > 0 && arr[j] < arr[j-1]) {
                    Sort.swap(arr, j, j-1);
                    j--;
                }
            }
        }
        return arr;
    }
}
