package cn.bw.leetcode;

public class L79单词搜索 {

    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(backtrack(board,word,i,j,0)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean backtrack(char[][] board, String word,
                              int x, int y, int k) {
        int rows = board.length;
        int cols = board[0].length;
        if (x < 0 || y < 0 || x >= rows || y >= cols || board[x][y] != word.charAt(k)) return false;
        if (k == word.length()-1) return true;

        board[x][y] = '.';
        boolean rs = backtrack(board, word, x + 1, y, k + 1) ||
                backtrack(board, word, x - 1, y, k + 1) ||
                backtrack(board, word, x, y + 1, k + 1) ||
                backtrack(board, word, x, y - 1, k + 1);
        board[x][y]=word.charAt(k);
        return rs;
    }
}
