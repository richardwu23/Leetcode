package cn.bw.leetcode;

public class L5最长回文子串 {

    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        int max = 0, begin = 0;

        for (int r = 0; r < len; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r)) {
                    boolean inner = dp[l + 1][r - 1] || r - l == 1;
                    if (r > 0 && l  < len-1 && inner) {
                        dp[l][r] = true;
                        if (max < r - l + 1) {
                            max = r - l + 1;
                            begin = l;
                        }
                    }
                }
            }
        }

        if (max == 0 && begin == 0) {
            return s.charAt(0) + "";
        } else {
            return s.substring(begin, begin + max);
        }



    }
}
