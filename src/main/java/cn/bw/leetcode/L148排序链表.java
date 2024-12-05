package cn.bw.leetcode;

import cn.bw.leetcode.common.ListNode;

public class L148排序链表 {

    /**
     * 思路：
     * 1.快慢指针分割链表
     * 2.合并链表

     * 注意：
     * fast.next != null && fast.next.next != null：
     * 保证快指针在链表中未越界。
     * 慢指针在链表长度为偶数时停在前半部分最后一个节点。
     * fast != null && fast.next != null：
     * 快指针停留在链表的最后一个节点时，慢指针可能偏右，不符合分割链表的要求。
     *
     *
     */
    public ListNode sortList(ListNode head) {

        if(head==null ||head.next==null){
            return head;
        }

        ListNode fast=head, slow=head;
        while (fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode tail = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(tail);

        return merge(left,right);


    }



    private ListNode merge(ListNode l1,ListNode l2){
        ListNode dy = new ListNode();
        ListNode cur = dy;

        while (l1!=null && l2!=null){
            int v1=l1.val, v2=l2.val;

            if(v1<v2){
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2=l2.next;
            }
            cur = cur.next;
        }

        if(l1!=null){
            cur.next = l1;
        }
        if(l2!=null){
            cur.next = l2;
        }
        return dy.next;

    }
}
