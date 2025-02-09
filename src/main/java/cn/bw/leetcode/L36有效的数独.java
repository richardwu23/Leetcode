package cn.bw.leetcode;

public class L36有效的数独 {

    public boolean isValidSudoku(char[][] board) {
        // 使用三个布尔数组来记录行、列和 3x3 子区域中是否出现过某个数字
        boolean[][] row = new boolean[10][10];  // row[i][u] 表示第 i 行是否出现过数字 u
        boolean[][] col = new boolean[10][10];  // col[j][u] 表示第 j 列是否出现过数字 u
        boolean[][] area = new boolean[10][10]; // area[idx][u] 表示第 idx 个 3x3 子区域是否出现过数字 u

        // 遍历整个 9x9 数独棋盘
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int c = board[i][j];  // 读取当前单元格的值
                if (c == '.') continue; // 如果是 '.'，表示空格，直接跳过

                int u = c - '0';  // 将字符 '1' ~ '9' 转换为整数 1 ~ 9
                int idx = (i / 3) * 3 + (j / 3); // 计算当前单元格所在的 3x3 子区域索引

                // 如果当前数字 u 在当前行、列或 3x3 子区域中已出现，则返回 false
                if (row[i][u] || col[j][u] || area[idx][u]) return false;

                // 记录当前数字 u 已经在当前行、列和 3x3 子区域中出现
                row[i][u] = col[j][u] = area[idx][u] = true;
            }
        }
        // 如果遍历完所有单元格都没有重复，说明是有效的数独棋盘
        return true;
    }

}
