package cn.bw.leetcode;

public class L10正则表达式匹配 {

    //dp[i][j] 表示（s 的前 i 个字符）是否能匹配（p 的前 j 个字符）
    //
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m+1][n+1];

        // 空串与空模式匹配
        dp[0][0] = true;

        // 初始化第一行：当s为空串时，p需要是如 "a*", "a*b*", ".*" 这种才能匹配
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        // 填充dp数组
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                if (pc == '.' || pc == sc) {
                    // 当前字符匹配，则看前面一段是否匹配
                    dp[i][j] = dp[i-1][j-1];
                } else if (pc == '*') {
                    // '*'的上一字符
                    char pPrev = p.charAt(j - 2);
                    // 匹配0次
                    dp[i][j] = dp[i][j-2];

                    // 匹配一次或多次时需要前面匹配且当前s字符与p[j-2]匹配
                    if (pPrev == '.' || pPrev == sc) {
                        dp[i][j] = dp[i][j] || dp[i-1][j];
                    }
                }
            }
        }

        return dp[m][n];
    }
}
