package cn.bw.leetcode;

import cn.bw.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class L95不同的二叉搜索树II {


    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> results = new LinkedList<>();
        if (n == 0) {
            return results;
        }
        return build(1, n);
    }

    private List<TreeNode> build(int s, int e) {
        List<TreeNode> results = new LinkedList<>();

        if (s > e) {
            // null表示 明确 是 空子树
            results.add(null);
            return results;
        }

        for (int i = s; i <= e; i++) {
            List<TreeNode> left = build(s, i - 1);
            List<TreeNode> right = build(i + 1, e);
            for (TreeNode leftTree : left) {
                for (TreeNode rightTree : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    results.add(root);
                }
            }
        }
        return results;
    }


}
