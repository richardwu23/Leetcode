package cn.bw.leetcode;

import cn.bw.leetcode.common.TreeNode;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

public class L662二叉树的最大宽度 {

    public int widthOfBinaryTree(TreeNode root) {
        int rs = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(new TreeNode(1, root.left, root.right));

        while (!queue.isEmpty()) {
            int cnt = queue.size(), start = -1, end = -1;

            for (int i = 0; i < cnt; i++) {
                TreeNode cur = queue.poll();
                end = cur.val;

                if (start == -1) start = cur.val;
                if (cur.left != null)
                    queue.add(new TreeNode(cur.val * 2,
                            cur.left.left,
                            cur.left.right));
                if (cur.right != null)
                    queue.add(new TreeNode(cur.val * 2 + 1,
                            cur.right.left,
                            cur.right.right));
            }
            rs = Math.max(rs, end - start + 1);
        }
        return rs;
    }

}
