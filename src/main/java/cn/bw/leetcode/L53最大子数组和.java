package cn.bw.leetcode;

public class L53最大子数组和 {

    public int maxSubArray(int[] nums) {
        int len=nums.length;

        int[] dp = new int[len];
        dp[0]=nums[0];
        int result=nums[0];
        for(int i=1;i<len;i++){
            if(dp[i-1]>0){
                dp[i]=dp[i-1]+nums[i];
            }else {
                dp[i]=nums[i];
            }
            result=Math.max(result,dp[i]);
        }

        return result;
    }

}
