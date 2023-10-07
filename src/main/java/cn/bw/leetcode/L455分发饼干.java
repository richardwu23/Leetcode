package cn.bw.leetcode;

import java.util.Arrays;

public class L455分发饼干 {

    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int glen=g.length, slen=s.length;
        int rs =0;

        for(int i=0,j=0;i<glen && j<slen;i++,j++){
            while (j<slen && g[i]>s[j]){
                j++;
            }
            if(j<slen){
                rs++;
            }
        }
        return rs;
    }
}
