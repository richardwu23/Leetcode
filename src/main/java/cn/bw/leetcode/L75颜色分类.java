package cn.bw.leetcode;

public class L75颜色分类 {

    /**
     * 思路： 交换，需要注意的是，cur =2 时 不能递增，
     * 因为交换后的值 需要重新检查
     */

    public void sortColors(int[] nums) {
        int i0=0,cur=0,i2=nums.length-1;

        while (cur<=i2){
            if(nums[cur]==0){
                swap(nums,cur,i0);
                i0++;
                cur++;
            }else if(nums[cur]==2){
                //注意 此时 cur 不能递增
                swap(nums,cur,i2);
                i2--;
            }else {
                cur++;
            }

        }


    }

    void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
}
