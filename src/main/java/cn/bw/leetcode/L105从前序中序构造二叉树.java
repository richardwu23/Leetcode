package cn.bw.leetcode;

import cn.bw.leetcode.common.TreeNode;

public class L105从前序中序构造二叉树 {

    int idx=0;
    public TreeNode buildTree(int[] preorder,
                              int[] inorder) {

        int len=preorder.length;

        return build(preorder,inorder,0,len-1);

    }

    TreeNode build(int[] preorder, int[] inorder, int left, int right){
        if(left>right) return null;
        //为什么有这行 是错误的
        if(left==right){
            idx++;
            return new TreeNode(inorder[left]);
        }

        int i = searchIdx(inorder,preorder[idx]);
        idx++;
        TreeNode root=new TreeNode(inorder[i]);
        root.left = build(preorder, inorder,left,i-1);
        root.right = build(preorder, inorder, i+1, right);

        return root;

    }

    int searchIdx(int[] inorder, int v){
        int idx=0;
        while (inorder[idx]!=v){
            idx++;
        }
        return idx;
    }



}
