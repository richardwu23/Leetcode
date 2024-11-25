package cn.bw.leetcode;

public class L34排序数组起止位置 {
    public int[] searchRange(int[] nums, int target) {
        int len=nums.length;
        int idx=binarySearch(nums,target);
        if(idx==-1){
            return new int[]{-1,-1};
        }

        int left=idx-1, right=idx+1;

        while (left>=0 && nums[left]==target){
            left--;
        }

        while (right<len && nums[right]==target){
            right++;
        }

        return new int[]{left+1,right-1};


    }

    private int binarySearch(int[] nums, int target){
        int len=nums.length;

        int left=0, right=len-1;

        while (left<=right){
            int mid = left+(right-left)/2;

            if(nums[mid]<target){
                left = mid+1;
            }else if(nums[mid]>target){
                right = mid-1;
            }else {
                return mid;
            }

        }
        return -1;
    }
}
