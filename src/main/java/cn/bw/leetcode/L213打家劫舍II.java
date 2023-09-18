package cn.bw.leetcode;

public class L213打家劫舍II {


    public int rob(int[] nums) {
        int len=nums.length;
        if(len==1)return nums[0];
        if(len==2)return Math.max(nums[0],nums[1]);

        int[] dp = new int[len];

        return Math.max(robRange(nums,0,len-2),
                robRange(nums,1,len-1));

    }


    private int robRange(int[] nums, int s, int e){
        int len=nums.length;
        if(len==1){
            return nums[s];
        }
        if(len==2){
            return Math.max(nums[s],nums[s+1]);
        }

        int[] dp = new int[len];
        dp[s]=nums[s];
        dp[s+1]=Math.max(nums[s],nums[s+1]);

        for(int i=s+2; i<=e;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[e];
    }

}
