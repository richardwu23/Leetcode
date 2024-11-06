package cn.bw.leetcode;

import java.util.Arrays;

/***
 * 思路：
 * 1.根据题意多个区间 可能重叠，需要排序， 规则按 第一个元素排序
 * 2.轮训区间  新建一个 数组 作为结果， 初始序号 从-1开始。
 * 3.区间元素 第一个 如果比 新数组 最后一个大 则合并。
 */
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
