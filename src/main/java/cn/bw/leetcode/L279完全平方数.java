package cn.bw.leetcode;

import java.util.Arrays;

public class L279完全平方数 {

    /**
     * dp[i] 表示 最少需要多少个数的平方 来表示 i
     */
    public int numSquares(int n) {

        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i<=n;i++ ){
            for(int j=1;j*j<=i;j++){
                dp[i]=Math.min(dp[i],dp[i-j*j]+1);
            }

        }

        return dp[n];
    }
}
