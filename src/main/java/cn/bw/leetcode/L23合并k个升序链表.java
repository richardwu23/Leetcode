package cn.bw.leetcode;

import cn.bw.leetcode.common.ListNode;

public class L23合并k个升序链表 {

    public ListNode mergeKLists(ListNode[] lists) {
        int len=lists.length;
        return merge(lists,0,len-1);
    }



    public ListNode merge(ListNode[] lists,int l, int r){
        if(l==r){
            return lists[l];
        }
        if(l>r){
            return null;
        }
        int mid = (l+r)>>1;
        return mergeTwo(merge(lists,l,mid),merge(lists,mid+1,r));

    }

    private ListNode mergeTwo(ListNode l1,ListNode l2){
        if(l1==null||l2==null){
            return l1!=null?l1:l2;
        }

        ListNode dummy=new ListNode();
        ListNode cur = dummy;

        while (l1!=null && l2!=null){
            int v1=l1.val;
            int v2=l2.val;
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
        return dummy.next;
    }

}
