package cn.bw.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L22括号生成 {


    //dp
    public List<String> generateParenthesis(int n) {
        // dp[i] 存储 i 对括号所产生的所有组合
        List<List<String>> dp = new ArrayList<>();
        dp.add(new ArrayList<>());
        dp.get(0).add(""); // dp[0] = [""]

        for (int i = 1; i <= n; i++) {
            List<String> currList = new ArrayList<>();
            // 将 i 对括号的组合构造成 "(" + dp[j] + ")" + dp[i-1-j]
            // j 从0到 i-1
            for (int j = 0; j < i; j++) {
                List<String> inside = dp.get(j);      // A 部分（被括在内的部分）
                List<String> outside = dp.get(i - 1 - j); // B 部分（紧随 ) 后面的部分）
                for (String inStr : inside) {
                    for (String outStr : outside) {
                        currList.add("(" + inStr + ")" + outStr);
                    }
                }
            }
            dp.add(currList);
        }

        return dp.get(n);
    }


    //backtrack
    public List<String> generateParenthesis0(int n) {
        List<String> r = new LinkedList<>();
        backtrack(n,0,0,new StringBuilder(),r);
        return r;

    }

    private void backtrack(int max,int left,int right,
                           StringBuilder sb,
                           List<String> res){
        if(sb.length()==max*2){
            res.add(sb.toString());
            return;
        }

        if(left<max){
            sb.append("(");
            backtrack(max,left+1,right,sb,res);
            sb.deleteCharAt(sb.length()-1);
        }

        if(right<left){
            sb.append(")");
            backtrack(max,left,right+1,sb,res);
            sb.deleteCharAt(sb.length()-1);
        }
    }

}
