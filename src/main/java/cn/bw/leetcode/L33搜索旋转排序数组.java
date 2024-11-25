package cn.bw.leetcode;

public class L33搜索旋转排序数组 {

    public int search(int[] nums, int target) {
        int len = nums.length;

        // 如果数组为空或长度为 0，直接返回 -1，表示未找到
        if (nums == null || len == 0) {
            return -1;
        }

        // 初始化二分查找的左右指针
        int left = 0, right = len - 1;

        // 开始二分查找
        while (left <= right) {
            // 计算中间索引，避免直接加法导致的溢出
            int mid = left + ((right - left) >> 1);

            // 如果中间元素是目标值，直接返回其索引
            if (target == nums[mid]) {
                return mid;
            }

            // 判断左半部分是否是有序的
            if (nums[left] <= nums[mid]) {
                // 如果目标值在左半部分范围内（包括左边界，不包括中间元素）
                if (target >= nums[left] && target < nums[mid]) {
                    // 收缩右边界到中间元素左侧
                    right = mid - 1;
                } else {
                    // 否则目标值不在左半部分，继续查找右半部分
                    left = mid + 1;
                }
            }

            // 判断右半部分是否是有序的
            if (nums[mid] <= nums[right]) {
                // 如果目标值在右半部分范围内（包括右边界，不包括中间元素）
                if (target > nums[mid] && target <= nums[right]) {
                    // 收缩左边界到中间元素右侧
                    left = mid + 1;
                } else {
                    // 否则目标值不在右半部分，继续查找左半部分
                    right = mid - 1;
                }
            }
        }

        // 如果遍历完未找到目标值，返回 -1
        return -1;
    }


}
