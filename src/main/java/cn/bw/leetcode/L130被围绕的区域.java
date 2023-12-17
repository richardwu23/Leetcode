package cn.bw.leetcode;

public class L130被围绕的区域 {

    public void solve(char[][] board) {
        int rows=board.length;
        int cols=board[0].length;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                boolean edge = i==0||j==0||
                        i==rows-1||j==cols-1;
                if(edge && board[i][j]=='O'){
                    dfs(board,i,j);
                }
            }
        }

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                if(board[i][j]=='#'){
                    board[i][j]='O';
                }
            }
        }
    }

    public void dfs(char[][] board, int x,int y){

        int rows=board.length;
        int cols=board[0].length;

        if(x<0||y<0||x>=rows||y>=cols||
                board[x][y]=='X'||
                board[x][y]=='#'){
            return;
        }

        board[x][y]='#';
        dfs(board,x+1,y);
        dfs(board,x-1,y);
        dfs(board,x,y+1);
        dfs(board,x,y-1);
    }
}
