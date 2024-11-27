package cn.bw.leetcode;

public class L62不同路径 {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        dp[0]=1;
        for(int r=0;r<m;r++){
            for(int c=0;c<n;c++){
                if(c>0){
                    dp[c] += dp[c-1];
                }
            }
        }
        return dp[n-1];

    }
}
