package cn.bw.leetcode;

public class L79单词搜索 {

    public boolean exist(char[][] board, String word) {
        // 遍历二维网格的每个位置，尝试从每个点作为起点进行深度优先搜索
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 如果从某个位置开始搜索成功，直接返回 true
                if (backtrack(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        // 如果所有起点都搜索失败，返回 false
        return false;
    }

    // 回溯方法：判断从网格 board[x][y] 开始，能否匹配单词 word 的第 k 个字符及其后续字符
    private boolean backtrack(char[][] board, int x, int y, String word, int k) {
        int rows = board.length, cols = board[0].length;
        // 边界条件：越界或当前字符不匹配
        if (x < 0 || y < 0 || x >= rows || y >= cols || board[x][y] != word.charAt(k)) {
            return false;
        }
        // 如果当前字符是单词的最后一个字符，说明匹配成功
        if (k == word.length() - 1) {
            return true;
        }
        // 标记当前单元格为已访问，避免重复使用
        char temp = board[x][y];
        board[x][y] = '.';

        // 尝试上下左右四个方向继续搜索
        boolean result =
                backtrack(board, x + 1, y, word, k + 1) || // 向下
                        backtrack(board, x - 1, y, word, k + 1) || // 向上
                        backtrack(board, x, y + 1, word, k + 1) || // 向右
                        backtrack(board, x, y - 1, word, k + 1);   // 向左
        // 回溯：恢复当前单元格的值
        board[x][y] = temp;
        return result;
    }

}
