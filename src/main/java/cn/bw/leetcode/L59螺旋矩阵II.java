package cn.bw.leetcode;

public class L59螺旋矩阵II {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1; // 要填入矩阵的当前数值
        int top = 0, bottom = n - 1; // 上边界和下边界
        int left = 0, right = n - 1; // 左边界和右边界

        while (top <= bottom && left <= right) {
            // 从左到右填充顶部一行
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;
            }
            top++;

            // 从上到下填充右侧一列
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            right--;

            // 从右到左填充底部一行（如果仍有底部行）
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = num++;
                }
                bottom--;
            }

            // 从下到上填充左侧一列（如果仍有左侧列）
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = num++;
                }
                left++;
            }
        }

        return matrix;
    }
}
