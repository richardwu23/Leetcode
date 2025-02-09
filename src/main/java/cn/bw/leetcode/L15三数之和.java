package cn.bw.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class L15三数之和 {

    /**
     * 排序+双指针
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // 首先对数组进行排序，以便后续使用双指针法处理

        List<List<Integer>> ans = new LinkedList<>(); // 用于存储满足条件的三元组结果

        // 遍历数组中的每一个元素，作为第一个元素nums[i]
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            //重复元素
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1, right = nums.length - 1;

            while (left < right) { // 使用双指针法
                int sum = nums[i] + nums[left] + nums[right];

                if (sum < 0) { // 如果和小于0，需要增大和，移动左指针
                    while (left < right && nums[left] == nums[++left]); // 跳过重复元素
                } else if (sum > 0) { // 如果和大于0，需要减小和，移动右指针
                    while (left < right && nums[right] == nums[--right]); // 跳过重复元素
                } else { // 如果和等于0，找到一个三元组
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right])); // 将三元组加入结果集
                    while (left < right && nums[left] == nums[++left]); // 跳过重复的左元素
                    while (left < right && nums[right] == nums[--right]); // 跳过重复的右元素
                }
            }
        }

        return ans;
    }



}
