package cn.bw.leetcode;

import java.util.Arrays;

/**
 https://leetcode.cn/problems/next-permutation/solutions/80560/xia-yi-ge-pai-lie-suan-fa-xiang-jie-si-lu-tui-dao-/?company_slug=bytedance
 */
public class L31下一个排列 {

    public void nextPermutation(int[] nums) {

        int len=nums.length;
        for(int i=len-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                Arrays.sort(nums,i,len);
                for(int j=i;j<len;j++){
                    if(nums[j]>nums[i-1]){
                        int t = nums[j];
                        nums[j]=nums[i-1];
                        nums[i-1]=t;
                        return;
                    }
                }

            }
        }
        Arrays.sort(nums);
    }
}
