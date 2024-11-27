package cn.bw.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class L438找到字符串中所有异位词 {

    // 滑动窗口
    //
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> results=new LinkedList<>();
        int slen=s.length(), plen=p.length();
        if(plen>slen)return results;

        int[] sc=new int[26], pc=new int[26];

        // 先取 p 长度 范围
        for(int i=0;i<plen;i++){
            pc[p.charAt(i)-'a']++;
            sc[s.charAt(i)-'a']++;
        }
        if(Arrays.equals(sc,pc)) results.add(0);

        for(int i=0;i<slen-plen;i++){
            // 核心代码， 滑动窗口内 比较
            sc[s.charAt(i)-'a']--;
            sc[s.charAt(i+plen)-'a']++;
            if(Arrays.equals(sc,pc)){
                results.add(i+1);
            }
        }

        return results;
    }
}
