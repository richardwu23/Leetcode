package cn.bw.leetcode;

import cn.bw.leetcode.common.ListNode;

public class L21合并两个有序链表 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        while (list1 != null && list2 != null) {
            int v1 = list1.val;
            int v2 = list2.val;
            if (v1 < v2) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        if (list1 != null) {
            cur.next = list1;
        }
        if (list2 != null) {
            cur.next = list2;
        }

        return dummy.next;
    }

}
