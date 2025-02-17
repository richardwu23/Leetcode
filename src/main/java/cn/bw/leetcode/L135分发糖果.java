package cn.bw.leetcode;

import java.util.Arrays;


//双数组贪心策略：
//先从 左向右遍历，保证所有 右边评分更高的孩子比左边多糖。
//再从 右向左遍历，保证所有 左边评分更高的孩子比右边多糖。
//结果取 两者的最大值，确保满足题目要求。
public class L135分发糖果 {


    public int candy(int[] ratings) {

        int len = ratings.length;
        int[] left = new int[len], right = new int[len];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        int result = 0;
        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
            result += Math.max(right[i], left[i]);
        }
        //注意  left[len-1];
        result += left[len - 1];
        return result;

    }

}
