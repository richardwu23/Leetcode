package cn.bw.leetcode;

import cn.bw.leetcode.common.TreeNode;

public class L337打家劫舍III {


    public int rob(TreeNode root) {
        if(root==null)return 0;
        if(root.left==null && root.right==null)return root.val;

        int[] res = robTree(root);

        return Math.max(res[0],res[1]);





    }

    private int[] robTree(TreeNode node){
        if(node==null)return new int[2];

        int[] left = robTree(node.left);
        int[] right=robTree(node.right);

        int[] res = new int[2];

        res[0]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        res[1]=left[0]+right[0]+node.val;
        return res;
    }

}
