package cn.bw.leetcode;

import java.util.HashMap;
import java.util.Map;

public class L146LRU缓存 {
    class LRUCache {

        Node head = new Node();
        Node tail = new Node();
        Map<Integer,Node> nodeMap = new HashMap<>();
        int capacity;
        public LRUCache(int capacity) {
            this.capacity = capacity;
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            Node node = nodeMap.get(key);
            if(node==null)return -1;

            node.next.pre=node.pre;
            node.pre.next = node.next;

            tail.pre.next = node;
            node.pre = tail.pre;
            node.next = tail;
            tail.pre = node;

            return node.value;
        }

        public void put(int key, int value) {
            Node node = nodeMap.get(key);
            if(node==null){
                node = new Node();
                node.key=key;
                node.value=value;

                nodeMap.put(key,node);
                int size=nodeMap.size();
                if(size>capacity){
                    Node delNode = head.next;

                    head.next = delNode.next;
                    delNode.next.pre = head;
                    nodeMap.remove(delNode.key);
                }

            }else {
                node.value=value;
                node.next.pre = node.pre;
                node.pre.next = node.next;
            }
            tail.pre.next = node;
            node.pre = tail.pre;
            node.next= tail;
            tail.pre = node;

        }

        class Node {
            int value;
            int key;
            Node pre;
            Node next;
        }
    }


}
