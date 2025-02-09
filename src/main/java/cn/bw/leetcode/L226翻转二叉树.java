package cn.bw.leetcode;

import cn.bw.leetcode.common.TreeNode;

public class L226翻转二叉树 {

    public TreeNode invertTree(TreeNode root) {
        if(root==null)return null;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;
        return root;
    }
}
