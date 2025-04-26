package cn.bw.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class L18四数之和 {


    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;

        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // 剪枝：最小值都大于 target，直接 break
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            // 剪枝：最大值都小于 target，继续下一个 i
            if ((long) nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3] < target) continue;

            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
                if ((long) nums[i] + nums[j] + nums[len - 1] + nums[len - 2] < target) continue;

                int l = j + 1;
                int r = len - 1;

                while (l < r) {
                    long sum = (long) nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum < target) {
                        l++;
                    } else if (sum > target) {
                        r--;
                    } else {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));

                        // 跳过重复的第三个数
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        // 跳过重复的第四个数
                        while (l < r && nums[r] == nums[r - 1]) r--;

                        // 移动指针
                        l++;
                        r--;
                    }
                }
            }
        }

        return ans;
    }


}
