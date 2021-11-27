package me.hqj.algorithms.leetcode;

import junit.framework.Assert;
import org.junit.Test;

public class LeetCode {

    @Test
    public void containerWithMostWater() {

        Assert.assertEquals(49, ContainerWithMostWater.maxArea(new int[] {1,8,6,2,5,4,8,3,7}) );
        Assert.assertEquals(17, ContainerWithMostWater.maxArea(new int[] {2,3,4,5,18,17,6}));
        Assert.assertEquals(16, ContainerWithMostWater.maxArea(new int[] {4,3,2,1,4}));
    }

    @Test
    public void length2OfLongestSubstring() {
        Assert.assertEquals(3, LengthOfLongestSubstring.lengthOfLongestSubstring("abcabcbb"));
        Assert.assertEquals(1, LengthOfLongestSubstring.lengthOfLongestSubstring("bbbb"));
        Assert.assertEquals(3, LengthOfLongestSubstring.lengthOfLongestSubstring("pwwkew"));
        Assert.assertEquals(0, LengthOfLongestSubstring.lengthOfLongestSubstring(""));
        Assert.assertEquals(1, LengthOfLongestSubstring.lengthOfLongestSubstring(" "));
        Assert.assertEquals(2, LengthOfLongestSubstring.lengthOfLongestSubstring("au"));
        Assert.assertEquals(6, LengthOfLongestSubstring.lengthOfLongestSubstring("avsdfag"));
        Assert.assertEquals(1, LengthOfLongestSubstring.lengthOfLongestSubstring("111111"));
    }

    @Test
    public void test() {
        String a = "a";
        String b = new String("a");
        System.out.println(a == b);
        System.out.println(a.equals(b));
    }

    @Test
    public void reverseKGroup() {
        ListNode head = new ListNode(1);
        ListNode curr = head;
        int i = 2;
        while(i < 20) {
            curr.next = new ListNode(i);
            curr = curr.next;
            i++;
        }
        curr = ReverseKGroup.reverseKGroup(head, 10);
//        curr = ReverseKGroup.reverseLink(head);
        while(curr != null) {
            System.out.print(curr.getVal()+" ");
            curr = curr.next;
        }
    }
}
