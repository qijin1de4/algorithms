package me.hqj.algorithms.sort;

import me.hqj.algorithms.sort.impl.*;
import org.junit.Assert;
import org.junit.Test;

public class SortTest {

    /**
     * quick sort
     */
    @Test
    public void sortTest() {
        // 快速排序
        Sort quickSort = new QuickSort();
        Assert.assertArrayEquals(new int[]{0,1,2,3,4,5,6,7,8,9,10}, quickSort.sort(new int[]{5,3,7,6,4,1,0,2,9,10,8}));

        // 插入排序
        Sort insertionSort = new InsertionSort();
        Assert.assertArrayEquals(new int[]{0,1,2,3,4,5,6,7,8,9,10}, insertionSort.sort(new int[]{5,3,7,6,4,1,0,2,9,10,8}));

        // 归并排序
        Sort mergeSort = new MergeSort();
        Assert.assertArrayEquals(new int[]{0,1,2,3,4,5,6,7,8,9,10}, mergeSort.sort(new int[]{5,3,7,6,4,1,0,2,9,10,8}));

        // 堆排序
        Sort heapSort = new HeapSort();
        Assert.assertArrayEquals(new int[]{0,1,2,3,4,5,6,7,8,9,10}, heapSort.sort(new int[]{5,3,7,6,4,1,0,2,9,10,8}));

    }
}
