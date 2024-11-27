package cn.bw.leetcode;

import java.util.HashMap;
import java.util.Map;

public class L1两数之和 {
    public int[] twoSum(int[] nums, int target) {
        // 创建一个哈希表，用于存储数组中已经访问过的元素及其索引
        Map<Integer, Integer> map = new HashMap<>();

        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 计算目标值与当前元素的差值
            int complement = target - nums[i];

            // 检查哈希表中是否存在该差值
            if (map.containsKey(complement)) {
                // 如果存在，返回差值和当前元素的索引
                return new int[] { map.get(complement), i };
            }

            // 如果差值不存在，将当前元素及其索引加入哈希表
            map.put(nums[i], i);
        }

        // 如果遍历完成仍未找到答案（题目保证一定有解，此处不会被执行）
        throw new IllegalArgumentException("No two sum solution");
    }

}
