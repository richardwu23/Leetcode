package cn.bw.leetcode;

public class L392判断子序列 {
    public boolean isSubsequence(String s, String t) {
        int slen=s.length(), tlen=t.length();
        int is=0;

        for(int i=0;i<tlen;i++){
            if(is==slen)return true;
            if(s.charAt(is)==t.charAt(i)){
                is++;
            }

        }
        return is==slen;
    }


}
