package cn.bw.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L22括号生成 {



    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        char[] current = new char[n * 2]; // 预分配空间存储括号组合
        backtrack(result, current, 0, 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, char[] current, int pos, int open, int close, int max) {
        // 如果当前构建的字符数组长度等于最大长度，加入结果
        if (pos == max * 2) {
            result.add(new String(current));
            return;
        }

        // 如果左括号数量小于最大值，添加左括号
        if (open < max) {
            current[pos] = '('; // 在当前位置放置左括号
            backtrack(result, current, pos + 1, open + 1, close, max);
        }

        // 如果右括号数量小于左括号数量，添加右括号
        if (close < open) {
            current[pos] = ')'; // 在当前位置放置右括号
            backtrack(result, current, pos + 1, open, close + 1, max);
        }
    }

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
