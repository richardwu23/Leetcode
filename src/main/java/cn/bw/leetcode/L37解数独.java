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

    public void solveSudoku(char[][] board) {

        // rowUsed[i][num] 表示第 i 行是否用过 num（1~9）
        boolean[][] row = new boolean[9][10];
        // colUsed[j][num] 表示第 j 列是否用过 num
        boolean[][] col = new boolean[9][10];
        // boxUsed[i][j][num] 表示第 i 行 j 列的 3x3 子盒是否用过 num
        boolean[][][] cell = new boolean[3][3][10];

        // 初始化：扫描整个数独盘面，把已经填好的数字在标记数组中做标记
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++) {
                int num = board[r][c] - '0';
                if(1 <= num && num <= 9){
                    row[r][num] = true;
                    col[c][num] = true;
                    cell[r/3][c/3][num] = true;
                }
            }
        }
        backtrack(board, row, col, cell, 0, 0);
    }

    // 回溯函数，尝试从 (row, col) 开始填盘面
    private boolean backtrack(char[][] board,
                                        boolean[][] row,
                                        boolean[][] col,
                                        boolean[][][] cell,
                                        int r,
                                        int c) {
        // 处理列越界，换行进入下一行的起始列
        if(c == board[0].length){
            c = 0;
            r++;
            // 如果 row 也越界了，说明整个盘面填完了，返回 true
            if(r == board.length){
                return true;
            }
        }
        // 如果当前位置是空格（'.'），尝试填 1 到 9
        if(board[r][c] == '.') {
            for(int num = 1; num <= 9; num++){
                // 检查当前数字是否在对应的行、列、3x3 方格中未被使用
                boolean canUsed = !(row[r][num] || col[c][num]
                        || cell[r/3][c/3][num]);
                if(canUsed){
                    // 标记使用
                    row[r][num] = true;
                    col[c][num] = true;
                    cell[r/3][c/3][num] = true;

                    // 将数字填入盘面
                    board[r][c] = (char)('0' + num);

                    // 继续递归填下一个格子
                    if(backtrack(board, row, col, cell, r, c + 1)){
                        return true; // 成功返回
                    }

                    // 回溯：撤销填入
                    board[r][c] = '.';
                    row[r][num] = false;
                    col[c][num] = false;
                    cell[r/3][c/3][num] = false;
                }
            }
        } else {
            // 如果当前格子不是空格，直接跳到下一个格子
            return backtrack(board, row, col, cell, r, c + 1);
        }

        // 所有数字尝试失败，返回 false
        return false;
    }




}
