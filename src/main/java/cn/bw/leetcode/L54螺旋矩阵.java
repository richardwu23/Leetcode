package cn.bw.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L54螺旋矩阵 {

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0)
            return new ArrayList<Integer>();

        // 初始化边界变量：左(l)、右(r)、上(t)、下(b)
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1;

        int x = 0;
        Integer[] res = new Integer[(r + 1) * (b + 1)];
        // 开始按照螺旋顺序遍历矩阵
        while (true) {
            // 从左到右遍历当前上边界的行
            for (int i = l; i <= r; i++)
                res[x++] = matrix[t][i];
            // 上边界向下移动，如果超出下边界，则结束
            if (++t > b) break;

            // 从上到下遍历当前右边界的列
            for (int i = t; i <= b; i++)
                res[x++] = matrix[i][r];
            // 右边界向左移动，如果超出左边界，则结束
            if (l > --r) break;

            // 从右到左遍历当前下边界的行
            for (int i = r; i >= l; i--)
                res[x++] = matrix[b][i];
            // 下边界向上移动，如果超出上边界，则结束
            if (t > --b) break;

            // 从下到上遍历当前左边界的列
            for (int i = b; i >= t; i--)
                res[x++] = matrix[i][l];
            // 左边界向右移动，如果超出右边界，则结束
            if (++l > r) break;
        }

        // 将结果数组转换为列表并返回
        return Arrays.asList(res);
    }



}
