package cn.bw.leetcode;

public class L12整数转罗马数字 {

    public String intToRoman(int num) {
        // 定义罗马数字和对应的整数值
        int[] values = {
                1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
        };
        String[] symbols = {
                "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
        };

        StringBuilder roman = new StringBuilder();

        // 遍历每个数值
        for (int i = 0; i < values.length; i++) {
            //注意 while
            while (num >= values[i]) {
                roman.append(symbols[i]);
                num -= values[i];
            }
        }
        return roman.toString();
    }

}
