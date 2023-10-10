package cn.bw.leetcode;

import java.util.Arrays;

public class L455分发饼干 {

    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int glen=g.length, slen=s.length;
        int rs =0;

        for(int gi=0,si=0;gi<glen && si<slen;gi++,si++){
            while (si<slen && g[gi]>s[si]){
                si++;
            }
            if(si<slen){
                rs++;
            }
        }
        return rs;
    }
}
