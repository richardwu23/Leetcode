package cn.bw.leetcode;

import java.util.Arrays;

/**
 https://leetcode.cn/problems/next-permutation/solutions/80560/xia-yi-ge-pai-lie-suan-fa-xiang-jie-si-lu-tui-dao-/?company_slug=bytedance
 */
public class L31下一个排列 {

    /**
     * 下一个排列 指的是 字典序排列 比当前排列更大的一个数字
     * 解法：  从后往前 把大的和前面小的 调换一下。
     * 注意： 尾部需要排序
     *
     */
    public void nextPermutation(int[] nums) {

        int len=nums.length;
        //注意  i>0
        for(int i=len-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                //注意  sort(nums, i, len)
                Arrays.sort(nums,i,len);
                for(int j=i;j<len;j++){
                    if(nums[j]>nums[i-1]){
                        int t = nums[j];
                        nums[j]=nums[i-1];
                        nums[i-1]=t;
                        return;
                    }
                }

            }
        }
        //注意
        Arrays.sort(nums);
    }


    public void nextPermutation1(int[] nums) {
        int len = nums.length;

        int i = len - 2;
        // Step 1: 找到第一个降序位置
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) { // 存在更大的排列
            int j = len - 1;
            // Step 2: 找到从后向前第一个比 nums[i] 大的数
            while (nums[j] <= nums[i]) {
                j--;
            }
            // 交换
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        // Step 3: 翻转 i+1 到 len-1，使其成为最小排列
        Arrays.sort(nums, i + 1, len);
    }

}
