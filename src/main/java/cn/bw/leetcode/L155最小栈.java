package cn.bw.leetcode;

public class L155最小栈 {

    class MinStack {

        /** initialize your data structure here. */
        public MinStack() {

        }

        class Node{
            int val;
            int min;
            Node next;

            Node(int val, int min){
                this.val=val;
                this.min = min;
                next = null;
            }
        }

        Node head;


        public void push(int x) {

            if(head==null){
                head = new Node(x,x);
            }else {
                Node node = new Node(x,Math.min(x,head.min));
                node.next = head;
                head = node;
            }


        }

        public void pop() {
            if(head!=null){
                head = head.next;
            }
        }

        public int top() {
            if(head!=null){
                return head.val;
            }else {
                return -1;
            }
        }

        public int getMin() {
            if(head!=null){
                return head.min;
            }else {
                return -1;
            }

        }
    }

}
