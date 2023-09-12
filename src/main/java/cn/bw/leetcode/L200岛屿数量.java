package cn.bw.leetcode;


//typical dfs solution  nothing to say
public class L200岛屿数量 {

    public int numIslands(char[][] grid) {

        int rows=grid.length;
        int cols=grid[0].length;
        int result=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    result++;
                }
            }
        }

        return result;
    }

    private void dfs(char[][] grid, int x, int y){
        int rows=grid.length;
        int cols=grid[0].length;

        if(x<0||y<0||x>=rows||y>=cols||grid[x][y]=='0'){
            return;
        }

        grid[x][y]='0';
        dfs(grid,x+1,y);
        dfs(grid,x-1,y);
        dfs(grid,x,y+1);
        dfs(grid,x,y-1);
    }
}
