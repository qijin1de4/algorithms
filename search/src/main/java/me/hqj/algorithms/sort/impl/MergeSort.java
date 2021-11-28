package me.hqj.algorithms.sort.impl;

import me.hqj.algorithms.sort.Sort;

/**
 * 归并排序
 * 归并排序是分治思想的体现，必须牢固掌握
 */
public class MergeSort implements Sort {
    @Override
    public int[] sort(int[] arr) {
        mergeSort(arr, 0, arr.length -1 );
        return arr;
    }

    /**
     * 归并排序
     * @param arr
     * @param lo 起点
     * @param hi 高点
     */
    private void mergeSort(int[] arr, int lo, int hi) {
        if(lo >= hi) return;
        int mid = lo + (hi -lo) /2;
        mergeSort(arr, lo, mid);
        mergeSort(arr, mid+1, hi);
        merge(arr, lo, mid, hi);
    }

    /**
     * 将数组左，右两半有序合并
     * @param arr
     * @param lo
     * @param mid
     * @param hi
     */
    private void merge(int[] arr, int lo, int mid, int hi) {
        int[] copy = new int[arr.length];
        System.arraycopy(arr, 0, copy, 0, arr.length); // 复制数据数据
        int k = lo, l = lo, r = mid +1; // k是遍历指针用于逐个处理元素。l：左半边子数组处理指针，r：右半边数组处理指针
        while(k <= hi) {
            if(l > mid) { // 左边子数组已经处理完了，只需将右边子数据组元素顺序放入arr即可
                arr[k++] = copy[r++];
            } else if( r > hi ) {// 同理：右边子数组已经处理完了，只需将左边子数据组元素顺序放入arr即可
                arr[k++] = copy[l++];
            } else if( copy[r] < copy[l]) { // 比较两边子数组对应下标元素，按照大小顺序放入到arr
                arr[k++] = copy[r++];
            } else {
                arr[k++] = copy[l++];
            }
        }
    }
}
