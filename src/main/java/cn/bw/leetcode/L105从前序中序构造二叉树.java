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
        //left  有可能 比 right 大， 当前子树 为空
        if(left>right) return null;

        if(left==right){
//            核心原因：idx 是全局变量，用于在前序遍历数组中定位当前处理的节点
            //为了让后续递归（比如构建兄弟节点或者右子树）能够正确处理下一个节点，
            // idx 必须往前移动一位。
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
