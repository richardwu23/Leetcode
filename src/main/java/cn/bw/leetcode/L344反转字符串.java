package cn.bw.leetcode;

public class L344反转字符串 {


    public void reverseString(char[] s) {
        int len=s.length;

        for(int l=0,r=len-1; l<r;l++,r--){
            char t = s[l];
            s[l]=s[r];
            s[r]=t;
        }



    }


}
