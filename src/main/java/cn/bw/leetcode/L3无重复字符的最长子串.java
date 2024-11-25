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
        Map<Character,Integer> map = new HashMap<>();
        int l=-1, ans=0, len=s.length();
        for(int r=0;r<len;r++){
            char c = s.charAt(r);
            if(map.containsKey(c)){
                l = Math.max(l,map.get(c));
            }
            map.put(c,r);
            ans = Math.max(ans,r-l);
        }

        return ans;

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
