package cn.bw.leetcode;

public class L136只出现一次的数字 {

    //解法： 异或运算符， 出现2次的 都为 0 。
    public int singleNumber(int[] nums) {
        if (nums == null||nums.length==0) {
            return 0;
        }
        int len = nums.length;
        int result = nums[0];
        for (int i = 1; i < len; i++) {
            result ^= nums[i];
        }
        return result;
    }
}
