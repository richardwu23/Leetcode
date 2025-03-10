package cn.bw.leetcode;

public class L41缺失的第一个正数 {
    public int firstMissingPositive(int[] nums) {
        // 边界条件处理：如果数组为空或长度为0，返回 1
        if (nums == null || nums.length == 0) return 1;

        int len = nums.length; // 获取数组长度

        int i = 0;
        while (i < len) { // 遍历数组，执行调整操作
            // 如果 nums[i] 已经在正确位置，跳过
            // 例如：nums[i] == i + 1
            if (nums[i] == i + 1) {
                i++;
                continue;
            }

            // 如果 nums[i] 小于 1 或大于数组长度，跳过
            // 例如：负数、0 或超过数组范围的数不参与排序
            if (nums[i] < 1 || nums[i] > len) {
                i++;
                continue;
            }

            // 获取当前数字 nums[i] 应该放置的正确位置 k = nums[i] - 1
            int k = nums[i];

            // 如果 nums[k-1] 已经是正确的值，说明不需要交换，跳过
            if (nums[k - 1] == k) {
                i++;
                continue;
            } else {
                // 否则，将 nums[i] 与 nums[k-1] 交换
                nums[i] = nums[k - 1];
                nums[k - 1] = k;
            }
        }

        // 遍历调整后的数组，寻找第一个位置 i 使得 nums[i] != i + 1
        for (i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1; // 返回第一个缺失的正整数
            }
        }

        // 如果所有数字都在正确位置，则返回 len + 1
        return len + 1;
    }

}
