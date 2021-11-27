package me.hqj.algorithms.leetcode.hard;

import org.junit.Test;

public class LeetCode {


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
