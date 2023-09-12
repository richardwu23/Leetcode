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
        int a=0,b=0,c=0;

        for(int i=1;i<n;i++){
            int n2=dp[a]*2, n3=dp[b]*3, n5=dp[c]*5;
            dp[i]=Math.min(Math.min(n2,n3),n5);
            if(dp[i]==n2) a++;
            if(dp[i]==n3) b++;
            if(dp[i]==n5) c++;
        }

        return dp[n-1];

    }

}
