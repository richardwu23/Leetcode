package cn.bw.leetcode;

public class L35搜索插入位置 {


    /**
     * 思路 二分查找， 如果目标不在数组中
     *
     循环结束的条件是 left > right。此时的状态可以总结为：
      right 停在 小于目标值的最后一个位置。
      left 停在 大于等于目标值的第一个位置，也就是目标值应该插入的位置。
     *
     * 题目要求： 返回它将会被按顺序插入的位置。
     * 因此是 left的位置
     */
    public int searchInsert(int[] nums, int target) {
        int len=nums.length;

        int left=0,right=len-1;
        while (left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]<target){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }

        return left;
    }

}
