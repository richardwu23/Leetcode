package cn.bw.leetcode;

public class L240搜索二维矩阵II {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false; // 边界条件，空矩阵直接返回 false
        }

        int rows = matrix.length;    // 矩阵的行数
        int cols = matrix[0].length; // 矩阵的列数

        // 从矩阵的右上角开始搜索
        int row = 0;          // 当前行
        int col = cols - 1;   // 当前列

        // 当没有越过矩阵的边界时继续搜索
        while (row < rows && col >= 0) {
            if (matrix[row][col]< target) {
                // 如果当前元素小于目标值，往下移动一行
                row++;
            } else if (matrix[row][col] > target) {
                // 如果当前元素大于目标值，往左移动一列
                col--;
            } else {

                return true;
            }
        }

        return false; // 如果搜索完成仍未找到目标值，返回 false
    }
}
