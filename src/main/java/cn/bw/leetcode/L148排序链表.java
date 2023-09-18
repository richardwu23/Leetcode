package cn.bw.leetcode;

import cn.bw.leetcode.common.ListNode;

public class L148排序链表 {

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
