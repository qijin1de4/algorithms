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
}
