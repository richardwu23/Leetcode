package cn.bw.leetcode;

public class L670最大交换 {

    /**
     * 思路：
     * 1.先转为char 数组，目的是方便知道每一位上的数字。
     * 2.记录每一个位上 数字（0-9）出现的最后位置，为了从后往前交换
     * 3.双层遍历，外层是遍历char数组，内层 遍历 从9到0。找到他们最后出现的位置，尝试交换
     *
     */
    public static int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        int len = digits.length;

        // 记录每个数字最后出现的索引，注意 是 10， 0～9；
        int[] lastIndex = new int[10];
        for (int i = 0; i < len; i++) {
            lastIndex[digits[i] - '0'] = i;
        }

        // 遍历数字，尝试找到更大的数字进行交换
        for (int i = 0; i < len; i++) {
            //注意  d > digits[i] - '0';
            for (int d = 9; d > digits[i] - '0'; d--) {
                if (lastIndex[d] > i) {
                    // 交换数字
                    char temp = digits[i];
                    digits[i] = digits[lastIndex[d]];
                    digits[lastIndex[d]] = temp;

                    // 返回结果
                    return Integer.parseInt(new String(digits));
                }
            }
        }

        // 如果没有找到可以交换的数字，直接返回原数字
        return num;
    }
}
