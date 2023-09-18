package cn.bw.leetcode;

import java.util.Stack;

public class L32最长有效括号 {

    public int longestValidParentheses(String s) {

        Stack<Integer> stack= new Stack<>();
        stack.push(-1);
        int result=0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('){
                stack.push(i);
            }else {
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else {
                    result = Math.max(result,i-stack.peek());
                }
            }
        }
        return result;

    }



}
