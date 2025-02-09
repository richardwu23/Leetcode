package cn.bw.leetcode;

public class L707设计链表 {

    class MyLinkedList {

        class Node {
            int val;
            Node prev; // 前驱节点
            Node next; // 后继节点
            Node(int val) {
                this.val = val;
            }
        }

        private Node head; // 链表头节点
        private Node tail; // 链表尾节点
        private int size;  // 链表长度

        public MyLinkedList() {
            head = null;
            tail = null;
            size = 0;
        }

        // 获取链表中下标为 index 的节点的值。如果下标无效，返回 -1
        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1; // 下标无效
            }
            Node cur = getNode(index); // 获取下标为 index 的节点
            return cur.val;
        }

        // 获取链表中下标为 index 的节点（辅助方法）
        private Node getNode(int index) {
            Node cur;
            if (index < size / 2) {
                // 从头开始遍历
                cur = head;
                for (int i = 0; i < index; i++) {
                    cur = cur.next;
                }
            } else {
                // 从尾开始遍历
                cur = tail;
                //注意 ** i>index
                for (int i = size - 1; i > index; i--) {
                    cur = cur.prev;
                }
            }
            return cur;
        }

        // 在链表的头部添加一个值为 val 的节点
        public void addAtHead(int val) {
            Node newNode = new Node(val);
            if (head == null) {
                head = tail = newNode; // 如果链表为空，头尾节点都指向新节点
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
            size++;
        }

        // 在链表的尾部添加一个值为 val 的节点
        public void addAtTail(int val) {
            Node newNode = new Node(val);
            if (tail == null) {
                head = tail = newNode; // 如果链表为空，头尾节点都指向新节点
            } else {
                newNode.prev = tail;
                tail.next = newNode;
                tail = newNode;
            }
            size++;
        }

        // 在链表中下标为 index 的位置插入值为 val 的节点
        public void addAtIndex(int index, int val) {
            if (index < 0 || index > size) {
                return;
            }
            if (index == 0) {
                addAtHead(val); // 在头部插入
            } else if (index == size) {
                addAtTail(val); // 在尾部插入
            } else {
                Node newNode = new Node(val);
                Node nextNode = getNode(index); // 获取下标为 index 的节点
                Node prevNode = nextNode.prev;

                newNode.prev = prevNode;
                newNode.next = nextNode;
                if (prevNode != null) {
                    prevNode.next = newNode;
                }
                nextNode.prev = newNode;
                size++;
            }
        }

        // 删除链表中下标为 index 的节点
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return; // 如果 index 无效，不删除
            }
            if (index == 0) {
                head = head.next; // 删除头节点
                if (head != null) {
                    head.prev = null;
                } else {
                    tail = null; // 如果链表为空，尾节点也置为 null
                }
            } else if (index == size - 1) {
                tail = tail.prev; // 删除尾节点
                if (tail != null) {
                    tail.next = null;
                } else {
                    head = null; // 如果链表为空，头节点也置为 null
                }
            } else {
                Node toDelete = getNode(index); // 获取下标为 index 的节点
                Node prevNode = toDelete.prev;
                Node nextNode = toDelete.next;

                prevNode.next = nextNode;
                nextNode.prev = prevNode;
            }
            size--;
        }
    }



}
