package cn.bw.leetcode;

public class L221最大正方形 {

    public int maximalSquare(char[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows + 1][cols + 1];
        int side = 0;
        // notice:    r<rows, c<cols;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (matrix[r][c] == '1') {

                    dp[r + 1][c + 1] = Math.min(dp[r][c],
                            Math.min(dp[r + 1][c], dp[r][c + 1])) + 1;
                    side = Math.max(side, dp[r + 1][c + 1]);
                }
            }
        }

        return side * side;
    }
}
