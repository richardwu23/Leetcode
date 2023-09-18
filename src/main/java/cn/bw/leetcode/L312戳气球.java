package cn.bw.leetcode;

public class L312戳气球 {

    // leetcode 312
    //https://leetcode.com/problems/burst-balloons/description/?source=submission-noac
    // solve: 1. dp;  dp[i][j] means  (i,j) max.

    public int maxCoins(int[] nums) {

        int len=nums.length;
        int[] s = new int[len+2];
        s[0]=s[len+1]=1;
        for(int i=1;i<=len;i++){
            s[i]=nums[i-1];
        }
        int[][] dp = new int[len+2][len+2];


        for(int i=1;i<=len;i++){
            //notice  left+i-1<=len
            for(int left=1;left+i-1<=len;left++){
                int right=left+i-1;
                //notice   k<=right
                for(int k=left;k<=right;k++){
                    dp[left][right]= Math.max(dp[left][right],
                            dp[left][k-1] + dp[k+1][right]+ s[left-1]*s[right+1]*s[k]);
                }
            }
        }

        //notice 1:len
        return dp[1][len];
    }

}
