package cn.bw.leetcode;

public class L35搜索插入位置 {


    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1, result = len;

        while (left <= right) {
            int mid = left + ((right - left) >> 1);

            if (target <= nums[mid]) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return result;
    }

}
