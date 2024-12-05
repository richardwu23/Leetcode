package cn.bw.leetcode;

import cn.bw.leetcode.common.TreeNode;


import java.util.*;

public class L662二叉树的最大宽度 {

    /**
     * 该代码计算 二叉树的最大宽度，即二叉树某一层的最右节点和最左节点在完全二叉树编号中的宽度差（包括这两个节点）。
     * 每个节点用完全二叉树的编号规则赋值：
     * 根节点为 1，
     * 左子节点为 2 * val，
     * 右子节点为 2 * val + 1。
     *
     * 队列 + 层序遍历
     *
     */
    public int widthOfBinaryTree(TreeNode root) {
        int rs = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(new TreeNode(1, root.left, root.right));

        while (!queue.isEmpty()) {
            int cnt = queue.size(), start = 0, end = -1;

            for (int i = 0; i < cnt; i++) {
                TreeNode cur = queue.poll();
                end = cur.val;

                if (start == 0) start = cur.val;
                if (cur.left != null)
                    queue.add(new TreeNode(cur.val * 2,
                            cur.left.left,
                            cur.left.right));
                if (cur.right != null)
                    queue.add(new TreeNode(cur.val * 2 + 1,
                            cur.right.left,
                            cur.right.right));
            }
            //notice:  end-start+1
            rs = Math.max(rs, end - start + 1);
        }
        return rs;
    }

}
