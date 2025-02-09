package cn.bw.leetcode;


import java.util.Arrays;

/**
 * https://leetcode.cn/problems/3sum-closest/
 * 16. 最接近的三数之和
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 *
 * 返回这三个数的和。
 *
 * 假定每组输入只存在恰好一个解。
 */
public class L16最接近的三数之和 {

    /**
     * 排序 + 双指针
     * 思路
     */
    public int threeSumClosest(int[] nums, int target) {

        int len=nums.length;
        Arrays.sort(nums);
        //注意，  初始化result
        int result=nums[0]+nums[1]+nums[2];

        for(int i=0;i<len-2;i++){
            int left=i+1, right=len-1;

            while (left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum==target){
                    return target;
                }
                if(Math.abs(sum-target)<Math.abs(result-target)){
                    result = sum;
                }

                if(sum>target){
                    right--;
                }else {
                    left++;
                }

            }

        }

        return result;
    }


    public static void main(String[] args){
        System.out.println("..hello world.");
    }

}
