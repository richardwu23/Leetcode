package cn.bw.leetcode;

public class L76最小覆盖子串 {


    public String minWindow(String s, String t) {


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
