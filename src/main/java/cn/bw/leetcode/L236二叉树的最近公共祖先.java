package cn.bw.leetcode;

import cn.bw.leetcode.common.TreeNode;

public class L236二叉树的最近公共祖先 {

    /**
     * 思路： 从root 往下走
     * 当 p==root 或者 q == root 时, 表示 走到了 p或q。
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root==null||p==root||q==root) return root;

        TreeNode leftP = lowestCommonAncestor(root.left,p,q);
        TreeNode rightP = lowestCommonAncestor(root.right,p,q);

        if(leftP==null){
            return rightP;
        }else if(rightP==null){
            return leftP;
        }else {
            return root;
        }

    }
}
