package cn.bw.leetcode;

import cn.bw.leetcode.common.ListNode;

public class L25K个一组翻转链表 {

    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || head.next == null) return head;

        // tail 最终指向 第 k 个节点的下一个节点，不包含在需要翻转的范围内。
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            // 如果剩余节点不足 k 个，不需要翻转，直接返回原链表
            if (tail == null) return head;
            tail = tail.next;
        }

        // 翻转当前组（head 到 tail 之间的节点）
        ListNode newHead = reverse(head, tail);

        // 翻转后的当前组尾部连接后续翻转的部分
        head.next = reverseKGroup(tail, k);

        // 返回新组的头节点
        return newHead;
    }

    // 翻转的范围是 [head, tail)，即包含 head，但不包含 tail。
    public ListNode reverse(ListNode head, ListNode tail) {
        ListNode pre = null, next = null;

        // 翻转链表，直到到达 tail
        while (head != tail) {
            next = head.next; // 暂存下一个节点
            head.next = pre;  // 当前节点指向前一个节点
            pre = head;       // 更新 pre 为当前节点
            head = next;      // 移动到下一个节点
        }

        // 返回翻转后的新头节点
        return pre;
    }


}
