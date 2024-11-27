package cn.bw.leetcode;

public class L918环形子数组的最大和 {


    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int[] leftMax = new int[n];
        // 对坐标为 0 处的元素单独处理，避免考虑子数组为空的情况
        leftMax[0] = nums[0];
        // 是从左到右累积的前缀和
        int leftSum = nums[0];
        //存储以当前元素结尾的最大子数组和
        int pre = nums[0];
        int res = nums[0];
        //非循环最大子数组和
        for (int i = 1; i < n; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            res = Math.max(res, pre);
            leftSum += nums[i];
            //记录了从第一个元素到第 i 个元素的最大前缀和。
            leftMax[i] = Math.max(leftMax[i - 1], leftSum);
        }

        // 从右到左计算后缀和。
        int rightSum = 0;
        for (int i = n - 1; i > 0; i--) {
            rightSum += nums[i];
            res = Math.max(res, rightSum + leftMax[i - 1]);
        }
        return res;
    }

}
