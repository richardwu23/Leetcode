package cn.bw.leetcode;

public class L48旋转图像 {


    //先沿 对角线 翻转， 再水平翻转
    public void rotate(int[][] matrix) {

        int rows = matrix.length;
        // **第一步：矩阵转置**
        // 将矩阵的第 i 行第 col 列元素与第 col 行第 i 列元素互换
        for (int i = 0; i < rows; i++) {
            for (int col = i; col < rows; col++) {
                int t = matrix[i][col];
                matrix[i][col] = matrix[col][i];
                matrix[col][i] = t;
            }
        }

        // **第二步：水平翻转每一行**
        // 将每一行的元素从左到右翻转
        for (int i = 0; i < rows; i++) {
            // 遍历当前行的前一半元素
            for (int j = 0; j < rows / 2; j++) {
                int t = matrix[i][rows - j - 1];
                matrix[i][rows - j - 1] = matrix[i][j];
                matrix[i][j] = t;
            }
        }
    }

}
