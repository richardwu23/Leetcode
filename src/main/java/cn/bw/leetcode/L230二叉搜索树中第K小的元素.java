package cn.bw.leetcode;

import cn.bw.leetcode.common.TreeNode;

import java.util.Stack;

public class L230二叉搜索树中第K小的元素 {

    public int kthSmallest(TreeNode root, int k) {

        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty()||root !=null){

            while (root!=null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            --k;
            if(k==0){
                return root.val;
            }
            root = root.right;



        }
        return 0;

    }
}
