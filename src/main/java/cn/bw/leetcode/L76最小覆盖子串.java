package cn.bw.leetcode;

import java.util.HashMap;

public class L76最小覆盖子串 {

    /**
     * 1. 收缩左指针的目的
     * 滑动窗口的初始操作是 扩展右指针，通过逐步扩大窗口包含更多字符，直到窗口内完全覆盖 t 中所有字符。
     * 当窗口包含 t 所有字符后，需要收缩左指针尝试减少窗口的大小。
     * 收缩窗口时，要保持窗口依然满足条件。
     * 同时更新记录最小窗口长度的变量。
     */

    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // 记录 t 中字符及其频次
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        // 滑动窗口中的字符及其频次
        HashMap<Character, Integer> windowMap = new HashMap<>();
        int left = 0, right = 0; // 双指针
        int minLen = Integer.MAX_VALUE; // 最小子串长度
        int start = 0; // 最小子串的起始位置
        int validCount = 0; // 满足 t 中字符数量条件的字符数

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            // 更新窗口中的字符计数
            if (tMap.containsKey(c)) {
                windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
                if (windowMap.get(c).equals(tMap.get(c))) {
                    validCount++;
                }
            }

            // 检查窗口是否满足条件
            while (validCount == tMap.size()) {
                // 更新最小子串
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                // 左指针收缩，移除窗口中的字符
                char d = s.charAt(left);
                left++;
                if (tMap.containsKey(d)) {
                    if (windowMap.get(d).equals(tMap.get(d))) {
                        validCount--;
                    }
                    windowMap.put(d, windowMap.get(d) - 1);
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }


    public String minWindow0(String s, String t) {


        char[] sc = s.toCharArray(),  tc=t.toCharArray();

        int slen=s.length();
        int tlen=t.length();
        int left=0,right=0, l=0,r=0, minLen=slen+1;
        int[] tmap = new int[128];

        for(char c : tc){
            tmap[c]++;
        }


        while (right<slen){
            if(tmap[sc[right]]>0){
                tlen--;
            }
            tmap[sc[right]]--;
            right++;

            while (tlen==0){
                if(right-left<minLen){
                    l=left;
                    r=right;
                    minLen = right-left;
                }

                tmap[sc[left]]++;
                if(tmap[sc[left]]>0){
                    tlen++;
                }
                left++;
            }
        }
        return minLen== slen+1?"":s.substring(l,r);

    }

}
