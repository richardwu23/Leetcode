package cn.bw.leetcode;

import cn.bw.leetcode.common.ListNode;

public class L24两两交换链表中的节点 {

    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode dummy = new ListNode();
        ListNode pre= dummy;
        dummy.next = head;

        while (head!=null && head.next!=null){

            pre.next = head.next;
            head.next = pre.next.next;

            pre.next.next = head;

            pre = pre.next.next;
            head = pre.next;
        }


        return dummy.next;
    }
}
