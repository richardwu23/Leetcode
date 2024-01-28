package cn.bw.leetcode;

public class L887鸡蛋掉落 {

    public int superEggDrop(int k, int n) {

        int[][] dp  = new int[k+1][n+1];

        for(int i=1;i<=n;i++){
            dp[0][i]=0;
            for(int j=1;j<=k;j++){
                dp[j][i]=dp[j][i-1] + dp[j-1][i-1]+1;
                if(dp[j][i]>=n){
                    return i;
                }
            }
        }
        return n;

    }
}
