package cn.bw.leetcode;

public class L44通配符匹配 {
    public boolean isMatch(String s, String p) {
        int slen = s.length(), plen = p.length();

        //dp[i][j] 表示 s 的前 i 个字符和 p 的前 j 个字符是否匹配
        boolean[][] dp = new boolean[slen + 1][plen + 1];

        // 初始化空字符串与空模式匹配
        dp[0][0] = true;

        // 初始化模式 p 的 '*' 能否匹配空字符串
        for (int i = 1; i <= plen; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 1];
            }
        }

        // 遍历 s 和 p
        for (int i = 1; i <= slen; i++) {
            for (int j = 1; j <= plen; j++) {

                // 如果当前字符匹配（相等或模式字符是 '?'），依赖于前一个状态
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];

                    // 如果模式字符是 '*'，它有两种选择：
                } else if (p.charAt(j - 1) == '*') {

                    // 1. '*' 匹配空字符串，依赖 dp[i][j - 1]
                    // 2. '*' 匹配 s 的当前字符，依赖 dp[i - 1][j]
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }

        // 返回整个字符串是否匹配
        return dp[slen][plen];
    }


}
