package cn.bw.leetcode;

import cn.bw.leetcode.common.ListNode;

public class L86分隔链表 {

    public ListNode partition(ListNode head, int x) {
        //注意  smallHead,bigHead 初始化为新节点
        ListNode smallHead=new ListNode(), bigHead=new ListNode();
        ListNode s=smallHead, b=bigHead;

        //注意， 因为有断开，所以 head = head.next;不能 提出来
        while (head!=null){
            if(head.val<x){
                s.next = head;
                s = s.next;

                head = head.next;
                s.next = null;
            }else {
                b.next = head;
                b = b.next;
                head = head.next;
                b.next = null;
            }
        }

        //注意
        s.next = bigHead.next;
        return smallHead.next;
    }
}
