package cn.bw.leetcode;

import java.util.Arrays;

public class L322零钱兑换 {

    /**
     dp, 背包问题
     dp[i] 表示 凑成 i 的 最少个数
     */
    public int coinChange(int[] coins, int amount) {


        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        //notice dp[0]=0;
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                if(coins[j]<=i){
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount]>amount?-1:dp[amount];


    }

}
