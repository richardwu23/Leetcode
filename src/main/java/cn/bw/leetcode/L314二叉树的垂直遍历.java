package cn.bw.leetcode;

import cn.bw.leetcode.common.TreeNode;

import java.util.*;

public class L314二叉树的垂直遍历 {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> results=new LinkedList<>();
        if(root==null) return results;

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        Queue<Integer> posQueue = new LinkedList<>();
        posQueue.offer(0);
        Map<Integer,List<Integer>> posValuesMap = new HashMap<>();

        int midPos = Integer.MAX_VALUE;

        while (!nodeQueue.isEmpty()){
            TreeNode node = nodeQueue.poll();
            int pos = posQueue.poll();

            List<Integer> list = posValuesMap.getOrDefault(pos,new LinkedList<>());
            list.add(node.val);
            posValuesMap.put(pos,list);

            if(node.left!=null){
                nodeQueue.offer(node.left);
                posQueue.offer(pos-1);
            }
            if(node.right!=null){
                nodeQueue.offer(node.right);
                posQueue.offer(pos+1);
            }
            midPos = Math.min(midPos,pos);
        }

        for(int i = midPos;i<midPos+posValuesMap.size();i++){
            results.add(posValuesMap.get(i));
        }
        return results;

    }

}
