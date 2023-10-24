package cn.bw.leetcode;

import java.util.Stack;

public class L84柱状图中最大矩形 {

    public int largestRectangleArea(int[] heights) {

        int len=heights.length;
        Stack<Integer> stack = new Stack<>();
        int rs =0;
        stack.push(-1);
        for(int i=0;i<len;i++){

            while (stack.peek()!=-1 && heights[stack.peek()]>=heights[i]){
                int h = heights[stack.pop()];
                int w = i-stack.peek() -1;
                rs = Math.max(rs,w*h);
            }
            stack.push(i);
        }

        while (stack.peek()!=-1){
            int h = heights[stack.pop()];
            int w = len-stack.peek()-1;
            rs = Math.max(rs,w*h);
        }

        return rs;

    }
}
