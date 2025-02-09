package cn.bw.leetcode;

import cn.bw.leetcode.common.TreeNode;

/**
 * 递归思路：
 * 对于每个节点，我们计算从该节点出发，沿着左右子树延伸所能获得的最大“贡献值”。若贡献值为负，则舍弃（使用 Math.max(..., 0)）。
 *
 * 更新全局最大值：
 * 当前节点可能成为“拐点”，即左右子树的最大贡献值加上当前节点的值构成一条路径，这条路径和可能比当前记录的全局最大路径和还大，所以进行更新。
 *
 * 返回值：
 * 递归函数返回的是当前节点对其父节点所能贡献的最大路径和，路径上不能同时包含左右子树，只能选取一边。
 */

public class L124二叉树中的最大路径和 {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    public int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 递归计算左右子节点的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        int priceNewpath = node.val + leftGain + rightGain;

        // 更新答案
        maxSum = Math.max(maxSum, priceNewpath);

        // 返回节点的最大贡献值
        return node.val + Math.max(leftGain, rightGain);
    }


}
