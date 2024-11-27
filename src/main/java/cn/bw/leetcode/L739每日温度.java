package cn.bw.leetcode;

import java.util.Stack;

public class L739每日温度 {

    //思路：  单调栈
    public int[] dailyTemperatures(int[] temperatures) {
        int len=temperatures.length;
        int[] ans = new int[len];
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<len;i++){
            // 如果当前温度比栈顶索引对应的温度高，更新结果
            while (!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){
                int idx=stack.pop();
//                计算当前天与栈顶天的索引差
                ans[idx]=i-idx;
            }
            stack.push(i);
        }

        return ans;
    }



}
