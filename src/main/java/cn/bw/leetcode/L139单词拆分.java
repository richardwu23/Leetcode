package cn.bw.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L139单词拆分 {
    /**
     * dp[i] 表示 s的前i个字符串 能否被 拼接
     *
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int len=s.length();
        Set<String> wordSet = new HashSet<>(wordDict);

        boolean[] dp=new boolean[len+1];
        dp[0]=true;
        for(int r=0;r<=len;r++){
            for(int l=0;l<r;l++){
                if(dp[l] && wordDict.contains(s.substring(l,r))){
                    dp[r]=true;
                }
            }
        }

        return dp[len];
    }
}
