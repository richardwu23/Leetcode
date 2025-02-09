package cn.bw.leetcode;

public class L8字符串转换整数 {

    public int myAtoi(String s) {

        s=s.trim();
        if(s.isEmpty())return 0;

        int idx=0, sign=1, ans=0;
        int len=s.length();

        if(s.charAt(0)=='-'||s.charAt(0)=='+'){
            sign = (s.charAt(0)=='-')?-1:1;
            idx++;
        }

        while (idx<len){
            char c = s.charAt(idx);
            if(!Character.isDigit(c)){
                break;
            }

            int digit = c - '0';

//            注意此处
            if(ans > (Integer.MAX_VALUE-digit)/10){
                return (sign==1)?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            ans = ans * 10 + digit;
            idx++;
        }
        return ans * sign;

    }


}
