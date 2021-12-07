package me.hqj.algorithms.leetcode.easy;

import me.hqj.algorithms.interv.FindSum;
import org.junit.Assert;
import org.junit.Test;

public class LeetCode {

    @Test
    public void validBrackets() {
        Assert.assertEquals(true, ValidBrackets.isValid("()[]{}"));
        Assert.assertEquals(false, ValidBrackets.isValid("([)]"));
        Assert.assertEquals(false, ValidBrackets.isValid("(]"));
        Assert.assertEquals(true, ValidBrackets.isValid("{[]}"));
    }

    @Test
    public void findSumTest() {
        FindSum fs = new FindSum();
        Assert.assertArrayEquals(new int[] {1,3}, fs.findSum(new int[] {2,3,5,7}, 10) );
        Assert.assertArrayEquals(new int[] {0,1}, fs.findSum(new int[] {3,3}, 6) );
    }
}
