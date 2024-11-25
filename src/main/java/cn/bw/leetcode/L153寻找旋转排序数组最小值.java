package cn.bw.leetcode;

public class L153寻找旋转排序数组最小值 {

    /**
     * 和普通二分查找解法 非常类似
     * 旋转的本质，仍然是部分有序，只不过有序的部分被分为两个部分。
     * 不旋转的有序数组，最大的是右侧边界，
     * 找最小值 也可以 和 右侧值比较。
     * 找最大值，则和左侧值 比较。
     *
     */
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            // 如果中间值大于右端点值，最小值在右半部分
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            // 如果中间值小于等于右端点值，最小值在左半部分或 mid 本身
            } else  {
                right = mid;
            }
        }
        // 循环结束时，left == right，指向最小值的位置
        return nums[left];

    }



}
