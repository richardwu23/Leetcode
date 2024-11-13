package cn.bw.leetcode;

import java.util.Stack;

public class L32最长有效括号 {

    /**
     * 如果当前字符是 ')'，先弹出栈顶元素，表示当前右括号试图与最近的左括号匹配。
     * 检查栈是否为空：
     * 如果栈为空，表示此时没有可以匹配的左括号。将当前右括号的索引 i 压入栈，
     * 以便作为新的有效子串的基准索引。
     * 如果栈不为空，说明栈顶元素是一个未匹配的左括号索引。
     * 此时，i - stack.peek() 计算出从栈顶元素索引
     * （上一个未匹配的右括号之后的索引）到当前右括号的长度，这个长度就是一个有效括号子串的长度。
     *
     *
     */
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
                    //此时没有可以匹配的左括号。
                    // 将当前右括号的索引 i 压入栈，
                    // 以便作为新的有效子串的基准索引。
                    stack.push(i);
                }else {
                    //如果栈不为空，说明栈顶元素是一个未匹配的左括号索引。
                    //i - stack.peek() 计算出从栈顶元素索引（上一个未匹配的右括号之后的索引）到当前右括号的长度，
                    // 这个长度就是一个有效括号子串的长度。
                    result = Math.max(result,i-stack.peek());
                }
            }
        }
        return result;

    }


    public int longestValidParentheses1(String s) {

        int len = s.length();
        int result = 0;
        int[] dp = new int[len];
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i > 2 ? dp[i - 2] : 0) + 2;
                } else if ((i - dp[i - 1] - 1 >= 0) && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1] - 2) > 0 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                result = Math.max(result,dp[i]);
            }
        }

        return result;

    }


}
