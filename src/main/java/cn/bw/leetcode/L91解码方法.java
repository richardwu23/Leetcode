package cn.bw.leetcode;

public class L91解码方法 {

    public int numDecodings(String s) {

        int len=s.length();
        int[] dp = new int[s.length()+1];

        //notice   dp[0]=1;
        dp[0]=1;

        dp[1]=s.charAt(0)!='0'?1:0;

        for(int i=2;i<=len;i++){

            if(s.charAt(i-1)!='0'){
                dp[i]=dp[i-1];
            }

            int twoDigits=(s.charAt(i-2)-'0') * 10+
                    s.charAt(i-1)-'0';

            if(twoDigits>=10 && twoDigits<=26){
                dp[i] +=dp[i-2];
            }
        }
        return dp[len];
    }
}
