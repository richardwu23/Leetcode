package cn.bw.leetcode;

import cn.bw.leetcode.common.ListNode;

public class L206反转链表 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, next=null;

        while (head!=null){
            next = head.next;
            head.next = pre;

            pre = head;
            head = next;
        }
        return pre;

    }
}
