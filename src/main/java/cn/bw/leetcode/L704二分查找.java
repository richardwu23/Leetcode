package cn.bw.leetcode;

public class L704二分查找 {
    public int search(int[] nums, int target) {
        int len=nums.length;
        int left=0,right=len-1;
        //注意， left<= right。 如果left<right 会错过 最后一个元素
        while (left<=right){
            int mid = left+(right-left)/2;

            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                right=mid-1;
            }else {
                left=mid+1;
            }

        }

        return -1;
    }
}
