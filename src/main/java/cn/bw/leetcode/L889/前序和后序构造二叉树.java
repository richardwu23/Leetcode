package cn.bw.leetcode.L889;

import cn.bw.leetcode.common.TreeNode;

public class 前序和后序构造二叉树 {

    public TreeNode constructFromPrePost(int[] preorder,
                                         int[] postorder) {
        int len=preorder.length;
        int[] map = new int[len+1];
        for(int i=0;i<len;i++){
            map[postorder[i]]=i;
        }
        return build(preorder,0,len,
                postorder,0,len,map);

    }

    TreeNode build(int[] pre,
                   int preL,int preR,
                   int[] pst, int pstL,
                   int pstR,int[] map){
        if(preL>preR||pstL>pstR) return null;
        if(preL==preR) return null;
        if(preL+1==preR) return new TreeNode(pre[preL]);

        int leftSize = map[pre[preL+1]]-pstL+1;
        TreeNode rightChild=build(pre,preL+1,preL+1+leftSize,
                pst,pstL,pstL+leftSize,map);
        TreeNode leftChild = build(pre,preL+1+leftSize,preR,
                pst,pstL+leftSize,pstR-1,map);
        return new TreeNode(pre[preL],leftChild,rightChild);
    }

}
