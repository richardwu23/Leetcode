package cn.bw.leetcode;

import java.util.Stack;

//单调栈
//可以转变为 84题解法，具体做法是 每行扫描计算高度，每行 扫描完全部列之后，计算一下当前面积 （84题）
public class L85最大矩形 {

    public int maximalRectangle(char[][] matrix) {
        int rows=matrix.length, cols=matrix[0].length;
        int[] h = new int[cols];
        int ans = 0;
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(matrix[r][c]=='0'){
                    h[c]=0;
                }else {
                    h[c] +=1;
                }
            }
            ans =Math.max(ans,getArea(h));
        }

        return ans;


    }

    int getArea(int[] h){
        int len=h.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int ans =0;
        for(int i=0;i<len;i++){
            while (stack.peek()!=-1 && h[stack.peek()]>=h[i]){
                int he = h[stack.pop()];
                int w = i-stack.peek()-1;
                ans = Math.max(ans,he*w);
            }
            stack.push(i);
        }

        while (stack.peek()!=-1){
            int hi = h[stack.pop()];
            int w = len-stack.peek()-1;

            ans=Math.max(ans,w*hi);
        }

        return ans;

    }
}
