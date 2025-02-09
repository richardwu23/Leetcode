package cn.bw.leetcode;

public class L1143最长公共子序列 {

    /**
     * dp解法
     * dp[i][j] 表示 text1 的 前i 和 text2的 前j 是公共子序列的长度
     * 因为表示空串， 所以 dp 长度是 len+1

     * dp[i-1][j] 的含义是：
     * 只比较 text1 的前 i-1 个字符和 text2 的前 j 个字符

     * dp[i][j-1] 的含义是：
     * 只比较 text1 的前 i 个字符和 text2 的前 j-1 个字符得到的 公共长度。

     * 这两个值代表的是不同的子问题选择路径，当当前字符不匹配时，
     * 我们尝试"向回退一步"看看能否在前面的部分找到更长的公共子序列。
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int len1=text1.length(), len2=text2.length();

        int[][] dp = new int[len1+1][len2+1];
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[len1][len2];
    }
}
