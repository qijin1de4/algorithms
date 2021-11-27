package me.hqj.algorithms.leetcode.hard;

/**
 * 给你一个链表，每k个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 */
public class ReverseKGroup {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
        public static ListNode reverseKGroup(ListNode head, int k) {

            ListNode result = head;

            ListNode pre = head;
            ListNode cur = head;
            ListNode nex = null;
            int count = 1;
            while(cur != null) {
                //分段
                if(count % k == 0) {
                    nex = cur.next;
                    cur.next = null;
                    if( count == k) { // 第一个子链表　
                        result = reverseLink(head);
                        head.next = nex;
                        pre = head;
                    } else {
                        ListNode temp = pre.next;
                        pre.next = reverseLink(temp);
                        temp.next = nex;
                        pre = temp;
                    }
                    cur = pre;
                }
                cur = cur.next;
                count++;
            }
            return result;
        }

    /**
     * 反转链表
     * @param head
     * @return
     */
        public static ListNode reverseLink(ListNode head) {
            if(head==null) return head;
            ListNode cur = head;
            ListNode pre = head;
            ListNode nex = cur.next;
            if(nex != null) {
                cur = nex;
                nex = nex.next;
                pre.next = null; //将头节点的next指向null，防止产生环　
            } else {
                return head;
            }
            while(nex != null) {
                cur.next = pre;
                pre = cur;
                cur = nex;
                nex = nex.next;
            }
            cur.next = pre;
            return cur;
        }
}
