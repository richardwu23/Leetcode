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

        Arrays.sort(nums);
        int ans = nums[0]+nums[1]+nums[2];
        for(int i=0;i<nums.length-2;i++){
            int l=i+1,r=nums.length-1;

            while (l<r){
                int sum = nums[i]+nums[l]+nums[r];
                if(sum==target){
                    return target;
                }else{
                    if(Math.abs(sum-target)<Math.abs(ans-target)){
                        ans = sum;
                    }
                    if(sum>target){
                        r--;
                    }else {
                        l++;
                    }
                }
            }
        }
        return ans;
    }


    public static void main(String[] args){
        System.out.println("..hello world.");
    }

}
