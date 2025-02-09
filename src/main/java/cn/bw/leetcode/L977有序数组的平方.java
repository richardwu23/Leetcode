package cn.bw.leetcode;

public class L977有序数组的平方 {

    /**
     * 双指针  O(n)
     *
     */
    public int[] sortedSquares(int[] nums) {
        int len=nums.length;
        int[] ans = new int[len];
        int l=0,r=len-1,i=len-1;
        while (l<=r){
            if(nums[l] * nums[l] > nums[r] * nums[r]){
                ans[i]=nums[l]*nums[l];
                l++;
            }else {
                ans[i]=nums[r]*nums[r];
                r--;
            }
            i--;
        }

        return ans;

    }
}
