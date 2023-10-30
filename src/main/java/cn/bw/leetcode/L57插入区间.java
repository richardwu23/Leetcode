package cn.bw.leetcode;

import java.util.Arrays;

public class L57插入区间 {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        int len = intervals.length;
        int[][] res = new int[len + 1][2];
        int idx = 0, i = 0;
        while (i < len && intervals[i][1] < newInterval[0]) {
            res[idx++] = intervals[i++];
        }

        while (i < len && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        res[idx++] = newInterval;

        while (i < len && newInterval[1] < intervals[i][0]) {
            res[idx++] = intervals[i++];
        }

        return Arrays.copyOf(res, idx);

    }

}
