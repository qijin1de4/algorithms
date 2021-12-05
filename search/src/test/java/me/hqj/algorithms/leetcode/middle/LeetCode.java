package me.hqj.algorithms.leetcode.middle;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.util.List;

public class LeetCode {

    @Test
    public void dailyTemperatures() {
        DailyTemprature dt = new DailyTemprature();
        Assert.assertArrayEquals(new int[] {1,1,4,2,1,1,0,0} ,dt.dailyTemperatures(new int[] {73,74,75,71,69,72,76,73}));
        Assert.assertArrayEquals(new int[] {1,1,1,0} ,dt.dailyTemperatures(new int[] {30,40,50,60}));
        Assert.assertArrayEquals(new int[] {1,1,0} ,dt.dailyTemperatures(new int[] {30,60,90}));
    }

    @Test
    public void combinationSum() {
        CombinationSum cs = new CombinationSum();
        List<List<Integer>> result = cs.combinationSum(new int[] {5,10,8,4,3,12,9}, 27);
        for(List<Integer> list : result) {
            System.out.print("[");
            for(int i : list) {
                System.out.print(i + ",");
            }
            System.out.println("]");
        }
    }

    @Test
    public void lengthOfLTS() {
        LengthOfLIS lts = new LengthOfLIS();
        Assert.assertEquals(4, lts.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        Assert.assertEquals(4, lts.lengthOfLIS(new int[]{0,1,0,3,2,3}));
        Assert.assertEquals(1, lts.lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
    }
}
