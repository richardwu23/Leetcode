package cn.bw.leetcode;

import cn.bw.leetcode.common.Node;

import java.util.HashMap;
import java.util.Map;

public class L138随机链表的复制 {


        //map key 原节点， value 复制节点，

        public Node copyRandomList(Node head) {
            if(head==null) return null;
            Node cur = head;
            Map<Node,Node> map = new HashMap<>();

            while (cur!=null){
                map.put(cur,new Node(cur.val));
                cur = cur.next;
            }

            cur =head;
            while (cur!=null){
                map.get(cur).next = map.get(cur.next);
                map.get(cur).random = map.get(cur.random);
                cur = cur.next;
            }

            return map.get(head);
        }

}
