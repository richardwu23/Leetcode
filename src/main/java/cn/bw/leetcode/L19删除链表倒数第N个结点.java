package cn.bw.leetcode;

import cn.bw.leetcode.common.ListNode;

public class L19删除链表倒数第N个结点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode front=head,back=head;

        for(int i=0;i<n;i++){
            front = front.next;
        }
        // 链表正好 n 个， 删除head
        if(front==null){
            head = head.next;
            return head;
        }
        //注意， front.next != null 表示 front 在倒数第一，back 在 n+1
        while (front.next!=null){
            front = front.next;
            back = back.next;
        }
        //back.next 指向 倒数第n个节点
        back.next = back.next.next;
        return head;
    }
}
