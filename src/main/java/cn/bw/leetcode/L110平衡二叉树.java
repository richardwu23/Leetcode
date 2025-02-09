package cn.bw.leetcode;

import cn.bw.leetcode.common.TreeNode;

public class L110平衡二叉树 {

    public boolean isBalanced(TreeNode root) {
        if(root==null)return true;
        return Math.abs(depth(root.left)-depth(root.right))<=1
                && isBalanced(root.left)
                && isBalanced(root.right);

    }

    int depth(TreeNode node){
        if(node==null)return 0;
        return Math.max(depth(node.left),depth(node.right))+1;
    }

}
