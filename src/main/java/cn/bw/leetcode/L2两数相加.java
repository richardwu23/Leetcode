package cn.bw.leetcode;

import cn.bw.leetcode.common.ListNode;

public class L2两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dy = new ListNode();
        ListNode cur = dy;
        int sum = 0;
        while (l1!=null || l2!=null){
            int v1 = l1==null?0:l1.val;
            int v2 = l2==null?0:l2.val;


            sum +=(v1+v2);
            cur.next = new ListNode(sum%10);
            sum /=10;

            if(l1!=null){
                l1 = l1.next;
            }

            if(l2!=null){
                l2 = l2.next;
            }

            cur = cur.next;
        }

        if(sum>0){
            cur.next = new ListNode(sum);
        }

        return dy.next;
    }

}
