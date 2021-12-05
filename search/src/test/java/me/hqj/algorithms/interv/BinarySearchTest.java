package me.hqj.algorithms.interv;

import junit.framework.Assert;
import org.junit.Test;

public class BinarySearchTest {

    @Test
    public void test() {
        int[] arr = {1, 2, 3, 5, 7, 9, 11, 12, 13, 14 , 15, 16};

        Assert.assertEquals(-1, BinarySearch.search(arr, 100));
        Assert.assertEquals(11, BinarySearch.search(arr, 16));
        Assert.assertEquals(4, BinarySearch.search(arr, 7));
    }
}
