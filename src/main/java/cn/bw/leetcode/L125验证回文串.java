package cn.bw.leetcode;

import java.util.Locale;

public class L125验证回文串 {

    public boolean isPalindrome(String s) {

        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                sb.append(Character.toLowerCase(c));
            }
        }
        int left=0,right=sb.length()-1;
        while (left<right){
            if(sb.charAt(left)!=sb.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

}
