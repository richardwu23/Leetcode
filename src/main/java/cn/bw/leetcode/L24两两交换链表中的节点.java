package cn.bw.leetcode;

import cn.bw.leetcode.common.ListNode;

public class L24两两交换链表中的节点 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dy = new ListNode();
        ListNode pre = dy;
        dy.next = head;
        while (head != null && head.next != null) {
            pre.next = head.next;
            head.next = pre.next.next;

            pre.next.next = head;

            pre = pre.next.next;
            head = pre.next;

        }
        return dy.next;
    }
}
