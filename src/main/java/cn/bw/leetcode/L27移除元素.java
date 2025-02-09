package cn.bw.leetcode;

public class L27移除元素 {


    public int removeElement(int[] nums, int val) {
        int idx=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] !=val){
                nums[idx++]=nums[i];
            }
        }

        //注意 idx  不是 idx-1
        return idx;
    }
}
