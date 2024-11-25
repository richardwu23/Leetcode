package cn.bw.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class L131分割回文串 {

    public List<List<String>> partition(String s) {
        Deque<String> path = new ArrayDeque<>();
        List<List<String>> rs = new ArrayList<>();
        backtrack(s, path, rs);
        return rs;
    }

    void backtrack(String s,
                   Deque<String> path,
                   List<List<String>> rs) {
        // 如果字符串为空（所有字符都已被分割），将当前路径加入结果集
        if (s == null || s.length() == 0) {
            rs.add(new ArrayList<>(path)); // 需要新建一个列表存储路径
            return;
        }

        // 遍历所有可能的分割点, 分割的时候，子串 不包含 i. 所以 i<=s.length()
        for (int i = 1; i <= s.length(); i++) {
            // 检查从起始到第 i 个字符是否是回文
            String substring = s.substring(0, i); // 当前分割出的子串
            if (isPali(substring)) { // 如果是回文
                path.add(substring); // 加入路径
                backtrack(s.substring(i), path, rs); // 递归处理剩余字符串
                path.removeLast(); // 回溯：撤销选择
            }
        }
    }

    // 判断一个字符串是否是回文
    boolean isPali(String s) {
        int left = 0, right = s.length() - 1;
        // 双指针向中间靠拢
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false; // 如果两端字符不同，不是回文
            }
            left++;
            right--;
        }
        return true; // 如果所有字符都对称，则是回文
    }

    // 测试方法
    public static void main(String[] args) {
        L131分割回文串 pp = new L131分割回文串();
        System.out.println(pp.partition("aab"));
    }



}
