package cn.bw.leetcode;

public class L5最长回文子串 {

    /**
     * dp
     *
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return ""; // 空串处理
        }

        int len = s.length();
        boolean[][] dp = new boolean[len][len]; // dp[i][j]表示s[i..j]是否为回文

        for (int i = 0; i < len; i++) {
            dp[i][i] = true; // 单字符必定是回文
        }

        int max = 1, begin = 0; // 初始化：单字符长度为1

        for (int r = 1; r < len; r++) { // 右边界从1开始（至少两个字符）
            for (int l = 0; l < r; l++) { // 遍历左边界
                if (s.charAt(l) == s.charAt(r)) { // 判断两端字符是否相等
                    // 子串长度为1或2时，直接为回文；否则参考内部子串是否回文
                    if (r - l == 1 || dp[l + 1][r - 1]) {
                        dp[l][r] = true; // 标记当前子串为回文

                        // 注意:更新最长回文的长度和起始索引
                        if (r - l + 1 > max) {
                            max = r - l + 1;
                            begin = l;
                        }
                    }
                }
            }
        }

        // 返回最长回文子串
        return s.substring(begin, begin + max);
    }

}
