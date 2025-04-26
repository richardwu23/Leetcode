package cn.bw.leetcode;

public class L96不同的二叉搜索树 {



    // dp[i] 表示 i 个节点的二叉搜索树（BST）的不同结构个数
    public int numTrees(int n) {

        int[] dp = new int[n + 1];
        // 0 个节点时，只有一种情况：空树
        dp[0] = 1;
        // 1 个节点时，只有一种情况：根节点自身
        dp[1] = 1;

        // 计算从 2 到 n
        for (int i = 2; i <= n; i++) {
            // 选择 j 作为根节点，左子树有 j-1 个节点，右子树有 i-j 个节点
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }



    public int numTrees1(int n) {
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
