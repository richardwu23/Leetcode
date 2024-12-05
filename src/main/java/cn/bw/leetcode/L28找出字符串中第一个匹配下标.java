package cn.bw.leetcode;

public class L28找出字符串中第一个匹配下标 {

    public int strStr(String haystack, String needle) {
        int hlen=haystack.length(), nlen=needle.length();
        char[] hc=haystack.toCharArray(), nc=needle.toCharArray();

        //notice  i<=hlen-nlen;
        for(int i=0;i<=hlen-nlen;i++){
            int hi=i, ni=0;

            while (ni<nlen && hc[hi]==nc[ni]){
                hi++;
                ni++;
            }
            if(ni==nlen){
                return i;
            }
        }
        return -1;


    }
}
