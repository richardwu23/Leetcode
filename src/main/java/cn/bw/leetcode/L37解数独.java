package cn.bw.leetcode;


/**
 * row[r][v]：
 * 表示数字 v（取值范围为 0 到 8，表示数独中的数字 1 到 9）已经在第 r 行中出现。
 * r 是行号，v 是数字的索引（board[r][c] - '1' 计算得到）。
 *
 * col[c][v]：
 * 表示数字 v 已经在第 c 列中出现。
 * c 是列号，v 是数字的索引。
 *
 * cell[r / 3][c / 3][v]： 表示数字 v 已经在所在的 3x3 子宫格中出现。
 * 子宫格通过行号和列号的整数除法定位：
 * r / 3：子宫格的行索引（总共 3 行子宫格）。
 * c / 3：子宫格的列索引（总共 3 列子宫格）。
 */
public class L37解数独 {

    boolean[][] row = new boolean[9][9];    // 记录每一行数字 1-9 是否已被使用
    boolean[][] col = new boolean[9][9];    // 记录每一列数字 1-9 是否已被使用
    boolean[][][] cell = new boolean[3][3][9]; // 记录每个 3x3 子宫格数字 1-9 是否已被使用

    public void solveSudoku(char[][] board) {
        //初始化
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') {  // 如果该位置已填数字
                    int v = board[r][c] - '1';  // 将字符转换为整数索引 (0-8)
//                     row[r][v]：表示数字 v（取值范围为 0 到 8，表示数独中的数字 1 到 9）已经在第 r 行中出现。
//                     r 是行号，v 是数字的索引（board[r][c] - '1' 计算得到）。
                    row[r][v] = col[c][v] = cell[r / 3][c / 3][v] = true;
                }
            }
        }

        backtrack(board, 0, 0);
    }

    //从左上开始 判断每行， 每列，每个cell 是否符合规则
    private boolean backtrack(char[][] board, int x, int y) {
        // 如果列到达末尾，转到下一行的第一列
        if (y == 9) return backtrack(board, x + 1, 0);
        // 如果行到达末尾，说明整个数独已成功填充
        if (x == 9) return true;
        // 如果当前位置已有数字，跳过到下一列
        if (board[x][y] != '.') return backtrack(board, x, y + 1);

        for (int i = 0; i < 9; i++) {  // 尝试放置数字 1-9
            if (!row[x][i] && !col[y][i] && !cell[x / 3][y / 3][i]) {
                board[x][y] = (char) ('1' + i);  // 将数字 i 转为字符放置到单元格
                // 更新状态
                row[x][i] = col[y][i] = cell[x / 3][y / 3][i] = true;
                if (backtrack(board, x, y + 1)) {  // 尝试填充下一单元格
                    break;  // 如果成功，跳出循环
                } else {  // 如果失败，回溯
                    board[x][y] = '.';  // 恢复单元格为空
                    row[x][i] = col[y][i] = cell[x / 3][y / 3][i] = false;  // 恢复状态
                }
            }
        }
        // 返回是否当前单元格已填入数字
        return board[x][y] != '.';
    }




}
