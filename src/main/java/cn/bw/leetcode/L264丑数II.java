package cn.bw.leetcode;


/**
 * https://leetcode.cn/problems/ugly-number-ii/
 * 264 丑数II
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 *
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 *
 * tag:dp
 */
public class L264丑数II {

    /**
     * dp 解法
     * 思路   dp[i-1]  是 第i个丑数
     *  a, b, c 分别是 指向，2，3，5的指针
     */

    public int nthUglyNumber(int n) {
        //notice  n
        int[] dp = new int[n];
        //notice:  0 -> 1
        dp[0]=1;
        int i2=0,i3=0,i5=0;

        for(int i=1;i<n;i++){
            int v2=dp[i2]*2, v3=dp[i3]*3, v5=dp[i5]*5;

            dp[i]=Math.min(v2,Math.min(v3,v5));
            if(dp[i]==v2) i2++;
            if(dp[i]==v3) i3++;
            if(dp[i]==v5) i5++;
        }

        return dp[n-1];

    }

}
