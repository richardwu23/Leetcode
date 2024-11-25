package cn.bw.leetcode;

import java.util.LinkedList;
import java.util.List;

public class L22括号生成 {

    public List<String> generateParenthesis(int n) {
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
