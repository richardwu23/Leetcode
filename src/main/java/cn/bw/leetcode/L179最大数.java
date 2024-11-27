package cn.bw.leetcode;

import java.util.Arrays;

public class L179最大数 {

    public String largestNumber(int[] nums) {
        // 将数字数组转换为字符串数组
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        // 对字符串数组进行自定义排序
        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));

        // 如果排序后的第一个字符串是 "0"，则所有数字都是 0
        if (strNums[0].equals("0")) {
            return "0";
        }

        // 拼接排序后的字符串数组
        StringBuilder result = new StringBuilder();
        for (String str : strNums) {
            result.append(str);
        }

        return result.toString();
    }


    public String largestNumber0(int[] nums) {
        int len = nums.length; // 数组长度
        String[] ss = new String[len]; // 创建一个字符串数组，将数字转换为字符串

        // 将数字转为字符串
        for (int i = 0; i < len; i++) {
            ss[i] = String.valueOf(nums[i]);
        }

        // 对字符串数组进行排序，按自定义规则排序
        sort(ss, 0, len - 1);

        // 如果排序后，最大的数字是 "0"，直接返回 "0"
        // 因为拼接的结果不可能比 "0" 更大
        if (ss[len - 1].equals("0")) return "0";

        // 拼接排序后的字符串
        StringBuilder sb = new StringBuilder();
        for (int i = len - 1; i >= 0; i--) {
            sb.append(ss[i]);
        }

        return sb.toString(); // 返回拼接后的字符串
    }

    void sort(String[] ss, int left, int right) {
        // 如果左边界大于右边界，返回（递归结束条件）
        if (left > right) return;

        int l = left, r = right; // 初始化左右指针
        String tmp = ss[l]; // 基准值，选择最左边的元素

        // 快速排序的核心逻辑
        while (l < r) {
            // 从右向左找到第一个需要交换的位置
            while ((ss[r] + ss[left]).compareTo(ss[left] + ss[r]) >= 0 && l < r) {
                r--;
            }
            // 从左向右找到第一个需要交换的位置
            while ((ss[l] + ss[left]).compareTo(ss[left] + ss[l]) <= 0 && l < r) {
                l++;
            }

            // 交换位置
            tmp = ss[r];
            ss[r] = ss[l];
            ss[l] = tmp;
        }

        // 将基准值放到分界点
        ss[l] = ss[left];
        ss[left] = tmp;

        // 递归排序左子数组
        sort(ss, left, l - 1);

        // 递归排序右子数组
        sort(ss, l + 1, right);
    }


}
