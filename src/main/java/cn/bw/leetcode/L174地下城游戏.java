package cn.bw.leetcode;

public class L174地下城游戏 {

    public int calculateMinimumHP(int[][] dungeon) {

        int rows=dungeon.length;
        int cols=dungeon[0].length;

        int[][] dp = new int[rows][cols];

        dp[rows-1][cols-1]=Math.max(0,-dungeon[rows-1][cols-1]);

        for(int i=rows-2;i>=0;i--){
            dp[i][cols-1]=Math.max(0,dp[i+1][cols-1]-dungeon[i][cols-1]);
        }

        for(int i=cols-2;i>=0;i--){
            dp[rows-1][i]=Math.max(0,dp[rows-1][i+1]-dungeon[rows-1][i]);
        }

        for(int i=rows-2;i>=0;i--){
            for(int j=cols-2;j>=0;j--){
                int need = Math.min(dp[i+1][j],dp[i][j+1])-dungeon[i][j];
                dp[i][j]=Math.max(0, need);
            }
        }

        return dp[0][0]+1;
    }

}
