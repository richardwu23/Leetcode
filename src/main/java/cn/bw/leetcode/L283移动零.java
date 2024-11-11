package cn.bw.leetcode;

public class L283移动零 {
    public void moveZeroes(int[] nums) {
        int len=nums.length, idx=0;
        for(int n:nums){
            if(n!=0){
                nums[idx++]=n;
            }
        }
        while (idx<len){
            nums[idx++]=0;
        }
    }
}
