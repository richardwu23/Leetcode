package cn.bw.leetcode;

public class L343整数拆分 {

    //dp，其中 dp[i] 表示数字 i 的最大乘积
    //状态转移方程 dp[i]=max(dp[i],max(j×(i−j),j×dp[i−j]))
    public int integerBreak(int n) {
        // 如果 n = 2 或 3，直接返回最大乘积
        if (n == 2) return 1;
        if (n == 3) return 2;

        // dp，其中 dp[i] 表示数字 i 的最大乘积
        int[] dp = new int[n + 1];

        // 初始
        dp[1] = 1;
        dp[2] = 1;

        // 填充 dp 数组
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                // 拆分为 j 和 i-j，取三种情况的最大值：
                // 1. 不拆分 i-j
                // 2. 拆分 i-j
                // 3. 当前最大值
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}
