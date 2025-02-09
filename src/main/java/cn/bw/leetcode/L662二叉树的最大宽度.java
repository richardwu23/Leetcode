package cn.bw.leetcode;

import cn.bw.leetcode.common.TreeNode;


import java.util.*;

public class L662二叉树的最大宽度 {

    /**
     *
     * 队列 + 层序遍历
     * 核心思想是利用完全二叉树的特性，对每个节点进行编号，编号方式为：

     * 根节点编号为 1。
     * 如果某节点编号为 x：
     * 其左子节点的编号为 2 * x。
     * 其右子节点的编号为 2 * x + 1。


       cur.left.left 和 cur.left.right 的目的
        是将节点的左子树的左右子树结构继续传递，以构造下一层的子节点。

     完全二叉树编号方法的性质保证了每层的宽度可以用 end - start + 1 计算。
     *
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
