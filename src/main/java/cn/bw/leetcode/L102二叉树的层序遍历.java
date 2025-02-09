package cn.bw.leetcode;

import cn.bw.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L102二叉树的层序遍历 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if(root==null)return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int size=queue.size();
            List<Integer> level=new LinkedList<>();
            for(int i=0;i<size;i++){
                TreeNode cur = queue.poll();
                if(cur.left!=null){
                    queue.offer(cur.left);
                }
                if(cur.right!=null)queue.offer(cur.right);

                level.add(cur.val);
            }
            ans.add(level);
        }
        return ans;


    }
}
