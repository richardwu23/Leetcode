package cn.bw.leetcode;

public class L37解数独 {

    boolean[][] row = new boolean[9][9];
    boolean[][] col = new boolean[9][9];
    boolean[][][] cell = new boolean[3][3][9];

    public void solveSudoku(char[][] board) {

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') {
                    int v = board[r][c] - '1';
                    row[r][v] = col[c][v] = cell[r / 3][c / 3][v] = true;
                }
            }
        }

        backtrack(board, 0, 0);
    }

    private boolean backtrack(char[][] board, int x, int y) {
        if (y == 9) return backtrack(board, x + 1, 0);
        if (x == 9) return true;
        if (board[x][y] != '.') return backtrack(board, x, y + 1);

        for (int i = 0; i < 9; i++) {

            if (!row[x][i] && !col[y][i] && !cell[x / 3][y / 3][i]) {
                board[x][y] = (char) ('1' + i);

                row[x][i]=col[y][i]=cell[x/3][y/3][i]=true;
                if(backtrack(board,x,y+1)){
                    break;
                }else {
                    board[x][y]='.';
                    row[x][i]=col[y][i]=cell[x/3][y/3][i]=false;
                }
            }
        }
        return board[x][y] !='.';
    }


}
