package cn.bw.leetcode;

public class L91解码方法 {

    /**
     * 每个数字 1 到 26 可以分别表示字母 A 到 Z。
     * 输入字符串 s 仅包含数字，可能包含 0，但不会有无效的编码。

     dp[i] 表示： 字符串 s 的前 i 个字符可以被解码的总方法数。
     dp[i] 并不是表示解码方式的累加值，
     而是表示从字符串开头到位置 i−1 的整个子字符串的解码方式总数。
     */
    public int numDecodings(String s) {

        int len=s.length();
        int[] dp = new int[s.length()+1];

        //notice   dp[0]=1;
        dp[0]=1;

        dp[1]=s.charAt(0)!='0'?1:0;

        for(int i=2;i<=len;i++){

            //如果当前字符 s[i-1]（索引从 0 开始）不是 '0'，则单独解码它是有效的
            if(s.charAt(i-1)!='0'){
                dp[i]=dp[i-1];
            }

            //如果当前字符和前一个字符组合成的两位数（twoDigits）在 [10, 26] 范围内，则可以解码为一个双字符的字母
            int twoDigits=(s.charAt(i-2)-'0') * 10+
                    s.charAt(i-1)-'0';

            if(twoDigits>=10 && twoDigits<=26){
                dp[i] +=dp[i-2];
            }
        }
        return dp[len];
    }
}
