package cn.bw.leetcode;

import java.util.Arrays;

public class L698划分K个相等的子集 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        int total=0;
        for(int i:nums){
            total +=i;
        }

        if(total%k!=0)return false;
        int len=nums.length, avg = total/k;
        boolean[] v = new boolean[len];

        return backtrack(nums,k,0,avg,0,len,v);

    }

    private boolean backtrack(int[] nums,
                              int k,
                              int cur,
                              int avg,
                              int cnt,
                              int len,
                              boolean[] v) {

        if (cnt == k) return true;
        if (cur == avg) return
                backtrack(nums, k,
                        0, avg, cnt + 1, len, v);

        for(int i=len-1;i>=0;i--){
            if(v[i] || cur+nums[i]>avg)
                continue;

            v[i]=true;
            if( backtrack(nums, k, cur+nums[i], avg, cnt, len, v)){
                return true;
            }
            v[i]=false;
            if(cur==0)return false;
        }
        return false;

    }
}
