package me.hqj.algorithms.sort;

import me.hqj.algorithms.sort.impl.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;

public class SortTest {

    /**
     * quick sort
     */
    @Test
    public void sortTest() {
        // 快速排序
        Sort quickSort = new QuickSort();
        Assert.assertArrayEquals(new int[]{0,1,2,3,4,5,6,7,8,9,10}, quickSort.sort(new int[]{5,3,7,6,4,1,0,2,9,10,8}));
        Assert.assertArrayEquals(new int[]{3,3,3,5,6,7,7,8,9,9,23,34,34,343,4656,4656,12321,57765,122344}, quickSort.sort(new int[]{3,3,3,7,9,122344,4656,34,34,4656,5,6,7,8,9,343,57765,23,12321}));

        Function<int[], int[]> quick = new QuickSort()::sort;
        Assert.assertArrayEquals(new int[]{3,3,3,5,6,7,7,8,9,9,23,34,34,343,4656,4656,12321,57765,122344}, quick.apply(new int[]{3,3,3,7,9,122344,4656,34,34,4656,5,6,7,8,9,343,57765,23,12321}));

        // 插入排序
        Sort insertionSort = new InsertionSort();
        Assert.assertArrayEquals(new int[]{0,1,2,3,4,5,6,7,8,9,10}, insertionSort.sort(new int[]{5,3,7,6,4,1,0,2,9,10,8}));
        Assert.assertArrayEquals(new int[]{3,3,3,5,6,7,7,8,9,9,23,34,34,343,4656,4656,12321,57765,122344}, insertionSort.sort(new int[]{3,3,3,7,9,122344,4656,34,34,4656,5,6,7,8,9,343,57765,23,12321}));

        // 希尔排序
        Sort shellSort = new ShellSort();
        Assert.assertArrayEquals(new int[]{0,1,2,3,4,5,6,7,8,9,10}, shellSort.sort(new int[]{5,3,7,6,4,1,0,2,9,10,8}));
        Assert.assertArrayEquals(new int[]{3,3,3,5,6,7,7,8,9,9,23,34,34,343,4656,4656,12321,57765,122344}, shellSort.sort(new int[]{3,3,3,7,9,122344,4656,34,34,4656,5,6,7,8,9,343,57765,23,12321}));

        // 归并排序
        Sort mergeSort = new MergeSort();
        Assert.assertArrayEquals(new int[]{0,1,2,3,4,5,6,7,8,9,10}, mergeSort.sort(new int[]{5,3,7,6,4,1,0,2,9,10,8}));
        Assert.assertArrayEquals(new int[]{3,3,3,5,6,7,7,8,9,9,23,34,34,343,4656,4656,12321,57765,122344}, mergeSort.sort(new int[]{3,3,3,7,9,122344,4656,34,34,4656,5,6,7,8,9,343,57765,23,12321}));

        // 堆排序
        Sort heapSort = new HeapSort();
        Assert.assertArrayEquals(new int[]{0,1,2,3,4,5,6,7,8,9,10}, heapSort.sort(new int[]{5,3,7,6,4,1,0,2,9,10,8}));
        Assert.assertArrayEquals(new int[]{3,3,3,5,6,7,7,8,9,9,23,34,34,343,4656,4656,12321,57765,122344}, heapSort.sort(new int[]{3,3,3,7,9,122344,4656,34,34,4656,5,6,7,8,9,343,57765,23,12321}));

    }
}
