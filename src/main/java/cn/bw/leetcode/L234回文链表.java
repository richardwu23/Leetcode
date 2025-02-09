package cn.bw.leetcode;

import cn.bw.leetcode.common.ListNode;

public class L234回文链表 {



    public boolean isPalindrome(ListNode head) {
        if(head==null)return true;
        ListNode fast=head,slow=head;
        //快慢指针
        //注意 条件，是停在 中间 偏左的节点， 如果偶数个节点。
        // 如果 条件 fast!=null && fast.next!=null, 则偏右节点。
        while (fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow=slow.next;
        }

        //翻转后半部
        ListNode cur=slow, pre=null;
        while (cur!=null){
            ListNode next=cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        ListNode l1 = head, l2=pre;
        while (l1!=null && l2!=null){
            if(l1.val!=l2.val){
                return false;
            }
            l1=l1.next;
            l2=l2.next;
        }

        return true;
    }

}
