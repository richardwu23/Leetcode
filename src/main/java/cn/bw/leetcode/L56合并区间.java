package cn.bw.leetcode;

import java.util.Arrays;

public class L56合并区间 {

    public int[][] merge(int[][] intervals) {

        //notice, sort first
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int len = intervals.length;
        //notice   start from -1
        int idx = -1;

        int[][] results = new int[len][2];


        for (int[] interval : intervals) {
            //notice, two case
            if (idx == -1 || interval[0] > results[idx][1]) {
                results[++idx]=interval;
            }else {
                results[idx][1]=Math.max(results[idx][1],interval[1]);
            }
        }
        //notice idx+1
       return Arrays.copyOf(results,idx+1);

    }
}
