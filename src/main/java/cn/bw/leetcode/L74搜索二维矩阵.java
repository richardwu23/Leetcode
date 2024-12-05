package cn.bw.leetcode;

public class L74搜索二维矩阵 {


    //解法： 把二维数组 看作一个 一维数组， 关键表达式 mid/cols, mid%cols
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols - 1;
        while (left <= right) {
            // 计算中间位置索引
            int mid = left + (right - left) / 2;

            // 根据矩阵的特点，将一维索引映射到二维矩阵的行列
            //注意： 关键表达式 mid/cols, mid%cols
            int midValue = matrix[mid / cols][mid % cols];

            // 如果中间值等于目标值，返回 true
            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                // 如果中间值小于目标值，缩小查找范围到右半部分
                left = mid + 1;
            } else {
                // 如果中间值大于目标值，缩小查找范围到左半部分
                right = mid - 1;
            }
        }

        // 如果遍历完成仍未找到目标值，返回 false
        return false;
    }

}
