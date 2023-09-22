package cn.bw.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class L215数组中的第K个最大元素 {



    public int findKthLargest(int[] nums, int k) {

        int len=nums.length;

        return  quickSelect(nums,0,len-1,len-k);


    }

    private int quickSelect(int[] nums, int left, int right, int kthSmall){

        if(right==left){
            return nums[left];
        }

        Random random = new Random();
        int pivotIdx = left + random.nextInt(right-left);

        pivotIdx = partition(nums,left,right,pivotIdx);
        if(kthSmall==pivotIdx){
            return nums[kthSmall];
        }else if(kthSmall<pivotIdx){
            return quickSelect(nums, left, pivotIdx-1, kthSmall);
        }else {
            return quickSelect(nums,pivotIdx+1,right,kthSmall);
        }
    }

    private int partition(int[] nums, int left, int right, int pivotIdx){

        int pivot = nums[pivotIdx];
        swap(nums,pivotIdx, right);

        int idx = left;
        for(int i=left;i<=right;i++){
            if(nums[i]<pivot){
                swap(nums,idx,i);
                idx++;
            }
        }
        swap(nums,idx,right);
        return idx;
    }

    private void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }





}
