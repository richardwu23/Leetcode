package cn.bw.leetcode;

import java.util.Arrays;

public class L238除自身外数组的乘积 {

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // 初始化所有元素为1，便于乘积计算
        Arrays.fill(answer, 1);

        // 前缀积：从左到右计算
        int prefix = 1;
        for (int i = 0; i < n; i++) {
            answer[i] = prefix; // 存储前缀积
            prefix *= nums[i]; // 更新前缀积
        }

        // 后缀积：从右到左计算
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= suffix; // 将后缀积与当前的前缀积相乘
            suffix *= nums[i]; // 更新后缀积
        }

        return answer;
    }

}
