package cn.bw.leetcode;

public class L96不同的二叉搜索树 {



    public int numTrees(int n) {
        // 动态规划数组，dp[i] 表示 i 个节点的二叉搜索树种数
        int[] dp = new int[n + 1];

        dp[0] = 1; // 空树只有一种情况
        dp[1] = 1; // 只有一个节点时也只有一种情况

        // 从 2 到 n 逐步计算 dp[i]
        for (int i = 2; i <= n; i++) {
            // 对每个节点数 i，尝试以每个节点 j 为根
            for (int j = 0; j < i; j++) {
                //左子树节点数为 𝑗，  右子树节点数 i-j-1
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
