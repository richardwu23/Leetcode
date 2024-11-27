package cn.bw.leetcode;

import cn.bw.leetcode.common.TreeNode;

public class L236二叉树的最近公共祖先 {


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
