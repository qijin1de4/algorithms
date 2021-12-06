package me.hqj.algorithms.leetcode.easy;

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
    public void binaryTreeDepth() {
        BinaryTreeMaxDepth btMax = new BinaryTreeMaxDepth();
        Assert.assertEquals(3, btMax.maxDepth(BinaryTreeMaxDepth.getTree()) );

        BinaryTreeMinDepth btMin = new BinaryTreeMinDepth();
        Assert.assertEquals(2, btMin.minDepth(BinaryTreeMaxDepth.getTree()) );
    }

    @Test
    public void towSum() {
        Assert.assertArrayEquals(new int[] {0,1}, TwoSum.twoSum(new int[]{2,7,11,15}, 9));
        Assert.assertArrayEquals(new int[] {1,2}, TwoSum.twoSum(new int[]{3,2,4}, 6));
        Assert.assertArrayEquals(new int[] {0,1}, TwoSum.twoSum(new int[]{3,3}, 6));
    }
}
