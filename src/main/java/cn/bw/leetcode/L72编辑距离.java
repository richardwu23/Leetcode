package cn.bw.leetcode;

public class L72编辑距离 {
    public int minDistance(String word1, String word2) {

        int len1=word1.length(),len2=word2.length();
// dp[i][j] 表示将 word1 的前 i 个字符转换为 word2 的前 j 个字符的最小编辑距离
        int[][] dp=new int[len1+1][len2+1];

        for(int i=0;i<=len1;i++){
            // 需要删除 i 个字符
            dp[i][0]=i;
        }

        for(int j=0;j<=len2;j++){
            // 需要插入 i 个字符
            dp[0][j]=j;
        }

        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else {
                    //替换dp[i-1][j-1]， 插入 dp[i][j-1] ， 删除 dp[i-1][j]
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]))+1;
                }
            }
        }
        return dp[len1][len2];

    }
}
