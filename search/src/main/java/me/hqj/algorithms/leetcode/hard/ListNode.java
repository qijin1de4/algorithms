package me.hqj.algorithms.leetcode.hard;

public class ListNode {
    int val;
    ListNode next = null;

    ListNode() {};

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

}
