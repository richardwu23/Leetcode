package cn.bw.leetcode;

/***
 * 思路：
 * dp[i][j][k]  表示  s1 从i开始, 到 s2 从j开始 到k个长度 是否可以
 */
public class L87扰乱字符串 {

    public boolean isScramble(String s1, String s2) {

        if(s1.equals(s2))return true;
        if(s1.length()!=s2.length())return false;
        int len=s1.length();

        boolean[][][] dp = new boolean[len][len][len+1];

        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                dp[i][j][1]=s1.charAt(i)==s2.charAt(j);
            }
        }

        for(int n=2;n<=len;n++){
            for(int i=0;i<=len-n;i++){
                for(int j=0;j<=len-n;j++){
                    for(int k=1;k<n;k++){
                        boolean a = dp[i][j][k] && dp[i+k][j+k][n-k];
                        boolean b = dp[i][j+n-k][k] && dp[i+k][j][n-k];
                        if(a||b){
                            dp[i][j][n]=true;
                        }
                    }
                }
            }
        }

        return dp[0][0][len];
    }
}
