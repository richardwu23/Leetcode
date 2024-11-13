package cn.bw.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class L15三数之和 {

    /**
     * 排序+双指针
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0) break;
            if(i>0 && nums[i]==nums[i-1]) continue;
            int left=i+1,right=nums.length-1;
            while (left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum<0){
                    while (left<right && nums[left]==nums[++left]);
                }else if(sum>0){
                    while (left<right && nums[right]==nums[--right]);
                }else {
                    ans.add(new LinkedList<>(Arrays.asList(nums[i],nums[left],nums[right])));
                    while (left<right && nums[left]==nums[++left]);
                    while (left<right && nums[right]==nums[--right]);
                }
            }
        }
        return ans;
    }


}
