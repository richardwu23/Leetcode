package cn.bw.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class L54螺旋矩阵 {

    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length==0)return new LinkedList<>();
        int rows=matrix.length, cols = matrix[0].length;
        int l=0,r=cols-1,t=0,b=rows-1;

        int x=0;
        Integer[] ans = new Integer[rows * cols];
        // 开始按照螺旋顺序遍历矩阵
        while (true){
            // 从左到右遍历当前上边界的行
            for(int i=l;i<=r;i++){
                ans[x++]=matrix[t][i];
            }
            // 上边界向下移动，如果超出下边界，则结束
            t++;
            if(t>b) break;

            // 从上到下遍历当前右边界的列
            for(int i=t;i<=b;i++){
                ans[x++]=matrix[i][r];
            }
            // 右边界向左移动，如果超出左边界，则结束
            r--;
            if(l>r)break;

            // 从右到左遍历当前下边界的行
            for(int i=r;i>=l;i--){
                ans[x++]=matrix[b][i];
            }
            // 下边界向上移动，如果超出上边界，则结束
            b--;
            if(t>b) break;

            // 从下到上遍历当前左边界的列
            for(int i=b;i>=t;i--){
                ans[x++]=matrix[i][l];
            }
            // 左边界向右移动，如果超出右边界，则结束
            l++;
            if(l>r)break;;
        }

        return Arrays.asList(ans);
    }



}
