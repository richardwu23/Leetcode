package cn.bw.leetcode;

public class L343整数拆分 {

    //dp，其中 dp[i] 表示数字 i 的最大乘积
    //状态转移方程 dp[i]=max(dp[i],max(j×(i−j),j×dp[i−j]))
    //计算三种情况的最大值：
    //j * (i - j): 直接拆成 j 和 i-j，不继续拆分 i-j。
    //j * dp[i - j]: 继续拆分 i-j，从 dp[i - j] 里获取其最大乘积。
    //取 dp[i] 的最大值，防止 dp[i] 在多个 j 中的比较时丢失最优解。
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}
