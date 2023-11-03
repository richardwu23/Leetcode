package cn.bw.leetcode;

import cn.bw.leetcode.common.Node;

import java.util.LinkedList;
import java.util.Queue;

public class L117填充每个节点下一个右侧节点指针II {

    public Node connect(Node root) {
        if(root==null)
            return root;


        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){

            int size=queue.size();
            Node pre = null;

            for(int i=0;i<size;i++){
                Node cur = queue.poll();

                if(i>0){
                    pre.next =cur;
                }
                if(cur.left!=null){

                    queue.add(cur.left);
                }

                if(cur.right!=null){

                    queue.add(cur.right);
                }

                pre = cur;
            }


        }
        return root;

    }
}
