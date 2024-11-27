package cn.bw.leetcode;

import java.util.Stack;

public class L394字符串解码 {


    /**
     * num 和 currentString：用来保存当前数字（即重复次数）和当前的字符序列。
     * 栈操作：
     * 当遇到数字时，累积数字，因为数字可以是多位的。
     * 当遇到 [ 时，将当前的字符序列和数字入栈，并重置 currentString 和 num。
     * 当遇到 ] 时，从栈中弹出字符序列和重复次数，构造新的字符串并更新 currentString。
     * 遇到普通字符（字母）时，直接加入 currentString 中。
     */
    public String decodeString(String s) {
        // 创建一个栈来存储当前的字符和重复的次数
        Stack<Object> stack = new Stack<>();
        int num = 0;  // 当前的重复次数
        StringBuilder currentString = new StringBuilder();  // 当前的解码字符串

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // 如果是数字，累积数字（考虑数字是多位的情况）
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                // 如果遇到 [，将当前的字符串和重复次数入栈
                stack.push(currentString.toString());
                stack.push(num);
                // 重置当前字符串和重复次数
                currentString = new StringBuilder();
                num = 0;
            } else if (c == ']') {
                // 如果遇到 ]，从栈中弹出重复次数和前一个解码的字符串
                int repeatTimes = (int) stack.pop();
                String prevString = (String) stack.pop();
                // 将当前解码的字符串重复指定次数并拼接到前面的字符串上
                for (int i = 0; i < repeatTimes; i++) {
                    prevString += currentString.toString();
                }
                // 更新当前字符串
                currentString = new StringBuilder(prevString);
            } else {
                // 如果是字母，直接加入当前字符串
                currentString.append(c);
            }
        }

        // 返回最终的解码字符串
        return currentString.toString();
    }

    public static void main(String[] args) {
        L394字符串解码 decoder = new L394字符串解码();
        System.out.println(decoder.decodeString("3[a]2[bc]")); // 输出 "aaabcbc"
        System.out.println(decoder.decodeString("3[a2[c]]"));  // 输出 "accaccacc"
        System.out.println(decoder.decodeString("2[abc]3[cd]ef")); // 输出 "abcabccdcdcdef"
        System.out.println(decoder.decodeString("abc3[cd]xyz")); // 输出 "abccdcdcdxyz"
    }
}
