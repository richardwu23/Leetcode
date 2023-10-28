package cn.bw.leetcode;

import cn.bw.leetcode.common.TreeNode;

public class L124二叉树中的最大路径和 {

    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null)return 0;
        getMax(root);
        return max;
    }

    int getMax(TreeNode cur){
        int left=0,right=0;
        int val=cur.val;

        if(cur.left!=null){
            left= getMax(cur.left);
        }

        if(cur.right!=null){
            right=getMax(cur.right);
        }

        val += Math.max(0,left)+Math.max(0,right);
        max = Math.max(max,val);

        return cur.val + Math.max(Math.max(left,0),Math.max(0,right));
    }



}
