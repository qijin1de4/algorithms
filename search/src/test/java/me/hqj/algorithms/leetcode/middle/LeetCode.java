package me.hqj.algorithms.leetcode.middle;

import org.junit.Assert;
import org.junit.Test;

public class LeetCode {

    @Test
    public void dailyTemperatures() {
        DailyTemprature dt = new DailyTemprature();
        Assert.assertArrayEquals(new int[] {1,1,4,2,1,1,0,0} ,dt.dailyTemperatures(new int[] {73,74,75,71,69,72,76,73}));
        Assert.assertArrayEquals(new int[] {1,1,1,0} ,dt.dailyTemperatures(new int[] {30,40,50,60}));
        Assert.assertArrayEquals(new int[] {1,1,0} ,dt.dailyTemperatures(new int[] {30,60,90}));
    }
}
