package cn.bw.leetcode;

public class L8字符串转换整数 {

    /**
     * 1.trim, 判断是否为空
     * 2.初始化变量
     * 3.判断符号
     * 4.遍历
     * 5.内部，判断是否是数字
     * 6.核心 ans*10 + digit
     * 7.判断是否越界
     *
     */
    public int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) return 0;

        int idx = 0;       // 当前字符索引
        int sign = 1;      // 符号，默认是正数
        int ans = 0;       // 最终返回的整数值
        int len = s.length();

        // 检查首字符是否为 '+' 或 '-'，确定符号位
        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            sign = (s.charAt(0) == '-') ? -1 : 1;
            idx++;  // 指针移动到下一个字符
        }

        // 遍历字符，逐个读取数字字符
        while (idx < len) {
            char c = s.charAt(idx);

            // 如果不是数字字符，停止解析
            if (!Character.isDigit(c)) {
                break;
            }

            int digit = c - '0';  // 将字符转为数字

            // 检查是否会溢出：ans * 10 + digit > Integer.MAX_VALUE
            // 即 ans > (Integer.MAX_VALUE - digit) / 10
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                // 如果会溢出，返回极值（正负视符号而定）
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            // 累加当前数字到结果中
            ans = ans * 10 + digit;
            idx++;
        }
        return ans * sign;
    }



}
