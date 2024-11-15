package cn.bw.leetcode;

import java.util.ArrayList;
import java.util.List;

public class L763划分字母区间 {

    public List<Integer> partitionLabels(String s) {
        // 第一步：计算每个字母最后出现的位置
        int[] lastIndex = new int[26]; // 用数组记录每个字母最后出现的位置
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        // 第二步：划分片段
        List<Integer> result = new ArrayList<>();
        int start = 0; // 记录当前片段的起始位置
        int end = 0;   // 记录当前片段的结束位置

        // 遍历字符串，动态更新片段的结束位置
        for (int i = 0; i < s.length(); i++) {
            // 更新当前字符的最后出现位置
            end = Math.max(end, lastIndex[s.charAt(i) - 'a']);

            // 如果当前字符的位置 i 已经到达片段的结束位置，说明可以划分一个片段
            if (i == end) {
                // 将当前片段的长度添加到结果中
                result.add(i - start + 1);
                start = i + 1; // 更新下一个片段的起始位置
            }
        }

        return result; // 返回所有划分的片段的长度
    }
}
