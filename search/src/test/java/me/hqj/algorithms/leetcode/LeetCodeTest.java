package me.hqj.algorithms.leetcode;

import junit.framework.Assert;
import org.junit.Test;

public class LeetCodeTest {

    @Test
    public void containerWithMostWater() {

        Assert.assertEquals(49, ContainerWithMostWater.maxArea(new int[] {1,8,6,2,5,4,8,3,7}) );
        Assert.assertEquals(17, ContainerWithMostWater.maxArea(new int[] {2,3,4,5,18,17,6}));
        Assert.assertEquals(16, ContainerWithMostWater.maxArea(new int[] {4,3,2,1,4}));
    }
}
