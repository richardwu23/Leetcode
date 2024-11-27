package cn.bw.leetcode;

public class L474一和零 {




    public int findMaxForm(String[] strs, int m, int n) {
        //dp[i][j]表示i个0和j个1时的最大子集
        int[][] dp = new int[m + 1][n + 1];
        int oneNum, zeroNum;
        for (String str : strs) {
            oneNum = 0;
            zeroNum = 0;
            for (char ch : str.toCharArray()) {
                if (ch == '0') {
                    zeroNum++;
                } else {
                    oneNum++;
                }
            }
            //倒序遍历
            for (int i = m; i >= zeroNum; i--) {
                for (int j = n; j >= oneNum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }
        return dp[m][n];
    }

    /**
     * dp[i][j][k] 表示在前 i 个字符串中，使用 j 个 0 和 k 个 1 的情况下最多可以得到的字符串数量
     *
     *
     *当 0 和 1 的容量分别是 j 和 k 时，考虑以下两种情况：
     *
     * 如果 j<zeros 或 k<ones，则不能选第 i 个字符串，此时有 dp[i][j][k]=dp[i−1][j][k]；
     *
     * 如果 j≥zeros 且 k≥ones，
     * 则如果不选第 i 个字符串，有 dp[i][j][k]=dp[i−1][j][k]，
     * 如果选第 i 个字符串，有 dp[i][j][k]=dp[i−1][j−zeros][k−ones]+1，dp[i][j][k] 的值应取上面两项中的最大值。
     *
     */
    public int findMaxForm1(String[] strs, int m, int n) {
        int length = strs.length;
        int[][][] dp = new int[length + 1][m + 1][n + 1];
        for (int i = 1; i <= length; i++) {
            int[] zerosOnes = getZerosOnes(strs[i - 1]);
            int zeros = zerosOnes[0], ones = zerosOnes[1];
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (j >= zeros && k >= ones) {
                        dp[i][j][k] =
                                Math.max(dp[i][j][k],
                                        dp[i - 1][j - zeros][k - ones] + 1);
                    }
                }
            }
        }
        return dp[length][m][n];
    }

    public int[] getZerosOnes(String str) {
        int[] zerosOnes = new int[2];
        int length = str.length();
        for (int i = 0; i < length; i++) {
            zerosOnes[str.charAt(i) - '0']++;
        }
        return zerosOnes;
    }

}
