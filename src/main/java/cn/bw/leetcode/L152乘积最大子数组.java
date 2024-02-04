package cn.bw.leetcode;

public class L152乘积最大子数组 {

    public int maxProduct(int[] nums) {

        int result=nums[0], min=nums[0],max=nums[0];

        for(int i=1;i< nums.length;i++){
            int pre = max;

            max = Math.max(nums[i],Math.max(nums[i]*max,nums[i]*min));
            min = Math.min(nums[i],Math.min(nums[i]*min,nums[i]*pre));

            result = Math.max(result,max);
        }

        return result;
    }
}
