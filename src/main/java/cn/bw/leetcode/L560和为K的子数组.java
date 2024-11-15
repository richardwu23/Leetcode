package cn.bw.leetcode;

import java.util.HashMap;
import java.util.Map;

public class L560和为K的子数组 {


    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int count =0;
        int pre=0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            pre +=nums[i];
            //根据前缀和的性质，如果当前的前缀和为 pre，并且之前有一个前缀和为 pre - k，
            // 那么从 pre - k 到当前位置的子数组和就等于 k。
            if(map.containsKey(pre-k)){
                count +=map.get(pre-k);
            }
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return count;
    }


    /**
     * 解法，前缀和
     *
     *
     *
     */
    public int subarraySum0(int[] nums, int k) {
        int len=nums.length;
        int[] presum = new int[len+1];
        for(int i=0;i<len;i++){
            presum[i+1]=presum[i]+nums[i];
        }
        int count=0;
        for(int l=0;l<len;l++){
            for(int r=l;r<len;r++){
                //注意 r+1
                if(presum[r+1]-presum[l] == k){
                    count++;
                }
            }
        }
        return count;
    }

}
