package cn.bw.leetcode;


/***
 * 这道题的解法：动态规划， 二分查找

 * dp 法
 * 定义 dp[i] 为考虑前 i 个元素，以第 i 个数字结尾的最长上升子序列的长度，
 * 注意 nums[i] 必须被选取。
 * O(n*n)

 * 二分法排序， 想象成 摆扑克牌 分堆。  top[i] 是每堆 最小
 * 最终的left 表示元素 cur 应该放的位置
 * O(n * log n)
 *
 */
public class L300最长增长子序列 {

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        // tops 数组用于模拟“扑克牌堆”，存放每个堆顶的最小元素
        int[] tops = new int[len];
        // piles 表示当前堆的数量
        int piles = 0;
        for (int i = 0; i < len; i++) {
            int cur = nums[i]; // 当前处理的数字
            int left = 0, right = piles;
            // 二分查找：在已有的牌堆中找到一个堆顶 >= cur 的最左位置
            while (left < right) {
                int mid = (left + right) >> 1;
                if (cur<=tops[mid]) {
                    right = mid; // 缩小范围，继续查找更左的堆
                } else {
                    left = mid + 1; // 向右查找
                }
            }

            // 如果没有找到合适的堆，说明需要新建一个堆
            if (left == piles) {
                piles++; // 增加堆的数量
            }
            // 将当前数放到找到的堆上
            tops[left] = cur;
        }
        // 堆的数量就是最长递增子序列的长度
        return piles;
    }

}
