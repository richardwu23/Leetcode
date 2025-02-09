package cn.bw.leetcode;

public class L9回文数 {

    /**
     * 思路： 翻转数字
     * old 表示原始数字，reverse 表示反转后的数字，
     * old%10 提取最后一位。
     * old/10 去掉最后一位
     *  reverse = reverse * 10 + old % 10;  将提取后的最后一位 加到反转后的数字上
     */
    public boolean isPalindrome(int x) {
        if(x<0)return false;

        int old=x, reverse=0;
        while (old!=0){
            reverse = reverse * 10 + old%10;
            old /=10;
        }
        return x==reverse;

    }
}
