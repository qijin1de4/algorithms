package me.hqj.algorithms.interv;

import junit.framework.Assert;
import org.junit.Test;

public class BinarSearchOnOrderedArrayTest {

    @Test
    public void test() {
        int[] arr = {1, 2, 3, 5, 7, 9, 11, 12, 13, 14 , 15, 16};

        Assert.assertEquals(-1, BinarSearchOnOrderedArray.search(arr, 100));
        Assert.assertEquals(11, BinarSearchOnOrderedArray.search(arr, 16));
        Assert.assertEquals(4, BinarSearchOnOrderedArray.search(arr, 7));
    }
}
