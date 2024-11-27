package cn.bw.leetcode;

import cn.bw.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class L94二叉树的中序遍历 {


    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> results=new ArrayList<>();
        if(root==null) return results;

        while (root!=null){
            if(root.left!=null){
                TreeNode predecessor = root.left;
                // notice : predecessor.right !=null
                while (predecessor.right!=null && predecessor.right!=root){
                    predecessor = predecessor.right;
                }

                //如果为空，pre.right 连上 root, root 往左走，如果不为空,说明右 已经遍历完，
                if(predecessor.right==null){
                    predecessor.right = root;
                    root = root.left;
                }else {
                    results.add(root.val);
                    predecessor.right = null;
                    root =root.right;
                }

            }else {
                results.add(root.val);
                root = root.right;
            }
        }

        return results;

    }

}
