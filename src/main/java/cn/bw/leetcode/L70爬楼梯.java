package cn.bw.leetcode;

public class L70爬楼梯 {

    /**
     * 为了 对齐 所以 dp长度 为n+1
     * 只需要 n 个长度的 dp 数组
     */
    public int climbStairs(int n) {
        if (n < 3) return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
