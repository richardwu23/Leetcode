package cn.bw.leetcode;

public class L209长度最小的子数组 {

    /**
     * 思路： 滑动窗口
     * left, right 窗口左右边界
     * min 最小窗口长度
     * s 目标值
     */
    public int minSubArrayLen(int s, int[] nums) {
        int len=nums.length;
        int left=0,right=0, sum=0, min=Integer.MAX_VALUE;

        while (right<len){
            sum+=nums[right++];
            while (sum>=s){
                min = Math.min(min,right-left);
                sum -= nums[left++];
            }
        }

        return min ==Integer.MAX_VALUE ? 0:min;
    }
}
