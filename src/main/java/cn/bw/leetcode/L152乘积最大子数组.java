package cn.bw.leetcode;

public class L152乘积最大子数组 {

    /**
     由于乘法的特殊性（正负数影响、零的干扰），无法像「最大子数组和」那样只使用一个 max 变量维护最大值。
     因此，需要同时跟踪最小乘积和最大乘积，以防止负数翻转情况。

     核心思路：
     max 记录以当前元素结尾的最大乘积，
     min 记录以当前元素结尾的最小乘积（因为负数 × 负数 可能变成更大的正数）。
     *
     */
    public int maxProduct(int[] nums) {

        int result=nums[0], min=nums[0],max=nums[0];

        for(int i=1;i< nums.length;i++){
            // 记录上一步的最大值
            int pre = max;

            max = Math.max(nums[i],Math.max(nums[i]*max,nums[i]*min));
            min = Math.min(nums[i],Math.min(nums[i]*min,nums[i]*pre));

            result = Math.max(result,max);
        }

        return result;
    }
}
