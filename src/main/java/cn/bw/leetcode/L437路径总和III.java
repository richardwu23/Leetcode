package cn.bw.leetcode;

import cn.bw.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class L437路径总和III {

    class Solution {

        /**
         * 前缀和 解法， DFS 也是可以的。
         */
        public int pathSum(TreeNode root, int targetSum) {
            Map<Long, Integer> prefix = new HashMap<Long, Integer>();
            prefix.put(0L, 1);
            return dfs(root, prefix, 0, targetSum);
        }

        /**
         * 深度优先搜索辅助函数
         * 寻找 preA = preB - target
         * 节点A 到 节点B 的路径和 为 target
         *
         * @param root      当前节点
         * @param prefix    存储前缀和及其出现次数的哈希映射
         * @param curr      当前路径上的累加和
         * @param targetSum 目标和
         * @return 满足条件的路径数量
         */
        public int dfs(TreeNode root, Map<Long, Integer> prefix, long curr, int targetSum) {
            if (root == null) {
                return 0;
            }

            int ret = 0;
            curr += root.val;

            // 检查是否存在之前的某个前缀和，使得当前和减去该前缀和等于 targetSum
            ret = prefix.getOrDefault(curr - targetSum, 0);

            // 更新当前前缀和的出现次数
            prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);

            // 递归遍历左子树和右子树
            ret += dfs(root.left, prefix, curr, targetSum);
            ret += dfs(root.right, prefix, curr, targetSum);

            // 回溯，移除当前节点的前缀和计数
            prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);

            return ret;
        }


    }
}

