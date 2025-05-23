package cn.bw.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class L51N皇后 {

    /**
     * 回溯算法，
     * 步骤， 逐行放
     *
     *
     */
    public List<List<String>> solveNQueens(int n) {
        // 存储所有可能的摆放结果
        List<List<String>> res = new ArrayList<>();
        // 数组 q 用于存储每一行皇后的位置，q[i] 表示第 i 行皇后放置在第 q[i] 列
        int[] q = new int[n];
        // 开始回溯
        backtrack(q, 0, res);
        return res;
    }

    // 回溯函数， pos 表示行索引
    private void backtrack(int[] q, int pos, List<List<String>> res) {
        int len = q.length;

        // 如果 pos 达到 n，说明所有行都已放置了皇后
        if (pos == len) {
            // 将当前棋盘状态转换为结果格式
            List<String> r = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                StringBuilder sb = addPoints(len); // 初始化一行的点
                sb.setCharAt(q[i], 'Q'); // 将皇后位置设置为 'Q'
                r.add(sb.toString());
            }
            res.add(r); // 将当前棋盘方案加入结果集
            return;
        }

        // 遍历当前行所有可能的列位置
        for (int i = 0; i < len; i++) {
            q[pos] = i; // 尝试将皇后放置在当前行的第 i 列
            if (isValid(q, pos)) { // 检查是否合法
                backtrack(q, pos + 1, res); // 如果合法，继续处理下一行
            }
        }
    }

    // 检查当前摆放是否合法
    private boolean isValid(int[] q, int pos) {
        for (int i = 0; i < pos; i++) {
            // 检查同列冲突
            if (q[i] == q[pos]) {
                return false;
            }
            // 检查对角线冲突
            if (Math.abs(i - pos) == Math.abs(q[i] - q[pos])) {
                return false;
            }
        }
        return true;
    }

    // 初始化一个 n 个 '.' 的字符串
    private StringBuilder addPoints(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(".");
        }
        return sb;
    }

}
