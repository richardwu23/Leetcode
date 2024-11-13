package cn.bw.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 解法： 滑动窗口 + 哈希表
 * map 统计 字符 s[i] 最后一次出现的索引
 idx 不重复的字符的 最右边的

 */
public class L3无重复字符的最长子串 {

    //将 i 初始化为 -1 可以简化计算并确保初始的无重复子串从索引 0 开始时能正确计入长度。
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> dict = new HashMap<>();
        int l=-1, res=0, len=s.length();
        for(int r=0;r<len;r++){
            if(dict.containsKey(s.charAt(r))){
                l = Math.max(l, dict.get(s.charAt(r)));
            }
            dict.put(s.charAt(r),r);
            res = Math.max(res, r-l);
        }
        return res;

    }







    public int lengthOfLongestSubstring0(String s) {
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
