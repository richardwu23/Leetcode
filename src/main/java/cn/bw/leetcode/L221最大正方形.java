package cn.bw.leetcode;

public class L221最大正方形 {

    //dp[i][j] 表示以 matrix[i-1][j-1] 为右下角的最大正方形的边长。

    public int maximalSquare(char[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows + 1][cols + 1];
        int side = 0;
        // notice:    r<rows, c<cols;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (matrix[r][c] == '1') {
                    //dp[r][c] 表示左上角，dp[r+1][c] 表示左边，dp[r][c+1] 表示上边。
                    dp[r + 1][c + 1] = Math.min(dp[r][c],
                            Math.min(dp[r + 1][c], dp[r][c + 1])) + 1;
                    //注意  dp[r+1][c+1]
                    side = Math.max(side, dp[r + 1][c + 1]);
                }
            }
        }

        return side * side;
    }
}
