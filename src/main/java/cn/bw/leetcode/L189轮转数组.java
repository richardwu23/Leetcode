package cn.bw.leetcode;

public class L189轮转数组 {

    /**
     * 我们需要将数组中的元素向右轮转 k 个位置。以下是解决问题的三种方法：

     * 额外数组法：使用一个额外数组，将新位置计算出来后存储。
     * 反转法：通过数组局部和整体反转来实现旋转。
     * 环状替换法：通过逐个元素重新定位，避免额外空间。

     * 这里采用 反转法，因为这种方法空间复杂度为 O(1)，且实现简单。
     * 反转法步骤

     * 反转整个数组：将数组所有元素顺序颠倒。
     * 反转前k 个元素：将前k 个元素还原到正确顺序。
     * 反转后面的元素：将剩余部分元素还原到正确顺序。
     * 关键点
     * k 可能大于数组长度n，因此需要取模操作 k=k%n。
     */
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // 确保 k 不超过数组长度
        // 步骤 1: 反转整个数组
        reverse(nums, 0, n - 1);
        // 步骤 2: 反转前 k 个元素
        reverse(nums, 0, k - 1);
        // 步骤 3: 反转后 n-k 个元素
        reverse(nums, k, n - 1);
    }

    // 辅助函数: 反转数组指定区间 [start, end]
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
