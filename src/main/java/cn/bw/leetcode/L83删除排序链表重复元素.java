package cn.bw.leetcode;

import cn.bw.leetcode.common.ListNode;

public class L83删除排序链表重复元素 {

    public ListNode deleteDuplicates(ListNode head) {

        ListNode dy = new ListNode();
        dy.next = head;

        while (head!=null && head.next!=null){
            if(head.val==head.next.val){
                head.next = head.next.next;
            }else {
                head = head.next;
            }
        }

        return dy.next;

    }


}
