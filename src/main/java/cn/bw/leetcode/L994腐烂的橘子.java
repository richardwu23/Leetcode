package cn.bw.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class L994腐烂的橘子 {
    /**
     * 思路： BFS
     *
     *
     *
     */
    public int orangesRotting(int[][] grid) {
        // 获取网格的行数和列数
        int rows = grid.length;
        int cols = grid[0].length;

        // 用队列保存腐烂的橘子的位置，采用BFS逐层传播腐烂
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0; // 记录新鲜橘子的数量

        // 遍历网格，初始化队列，将所有腐烂的橘子位置加入队列，同时统计新鲜橘子的数量
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) { // 腐烂的橘子
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) { // 新鲜的橘子
                    freshOranges++;
                }
            }
        }

        // 如果没有新鲜橘子，直接返回0
        if (freshOranges == 0) {
            return 0;
        }

        // 四个方向数组，用于向上下左右扩展腐烂
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int minutes = 0; // 记录时间（分钟）

        // 开始BFS，直到没有可以腐烂的新鲜橘子
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean hasRot = false; // 是否在这一轮腐烂了新的橘子
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int row = current[0], col = current[1];

                // 尝试向四个方向扩展腐烂
                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    // 判断是否在网格范围内，且当前位置是新鲜橘子
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
                        // 腐烂该橘子，并将其加入队列
                        grid[newRow][newCol] = 2;
                        queue.offer(new int[]{newRow, newCol});
                        freshOranges--; // 新鲜橘子减少
                        hasRot = true; // 表示这一轮有腐烂发生
                    }
                }
            }

            // 如果有橘子腐烂，则增加分钟数
            if (hasRot) {
                minutes++;
            }
        }

        // 如果还有新鲜橘子，返回-1，否则返回经过的时间
        return freshOranges == 0 ? minutes : -1;
    }
}
