package cn.bw.leetcode;

import java.util.HashSet;
import java.util.Set;

public class L128最长连续序列 {

    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        for (int i : nums) {
            //  如果set包含i 则 set.remove(i) 返回true
            if (set.remove(i)) {
                int pre = i - 1;
                int next = i + 1;
                // 向前扩展连续序列，移除集合中的连续数字
                while (set.remove(pre)) {
                    pre--; // 继续向前扩展
                }
                // 向后扩展连续序列，移除集合中的连续数字
                while (set.remove(next)) {
                    next++; // 继续向后扩展
                }
                ans = Math.max(ans, next - pre - 1);
                // next 是序列结束的下一个数字，pre 是序列开始的前一个数字
                // 所以序列长度为 (next - pre - 1)
            }
        }
        return ans;
    }

}
