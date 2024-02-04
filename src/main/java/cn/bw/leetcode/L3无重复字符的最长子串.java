package cn.bw.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 idx 不重复的字符的 最右边的

 */
public class L3无重复字符的最长子串 {



    public int lengthOfLongestSubstring(String s) {
        int len=s.length(), result=0, idx=0;

        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<len;i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                idx = Math.max(map.get(c),idx);
            }
            result = Math.max(result, i-idx+1);
            map.put(c,i+1);
        }
        return result;

    }
}
