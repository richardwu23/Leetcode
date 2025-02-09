package cn.bw.leetcode;

import cn.bw.leetcode.common.ListNode;

public class L92反转链表II {

    /**
     * 思路：  先把左右两个节点 单独摘出来，反转 再联回去
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;

        //走到 left 前一个 节点
        for(int i=0;i<left-1;i++){
            pre = pre.next;
        }

        ListNode rightNode = pre;

        //继续走 right 到 left 的距离
        for(int i=0;i<right-left+1;i++){
            rightNode = rightNode.next;
        }

        ListNode leftNode = pre.next;

        ListNode cur = rightNode.next;

        //断开
        pre.next = null;
        rightNode.next = null;

        reverse(leftNode);

        pre.next = rightNode;
        leftNode.next = cur;

        return dummy.next;
    }



    void reverse(ListNode head){
        ListNode cur = head, next=null, pre=null;

        while (cur!=null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }
}
