package cn.bw.leetcode;

public class L76最小覆盖子串 {


    public String minWindow(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();

        int[] tmap = new int[128];
        int right=0,left=0;

        int count=t.length();
        int slen=s.length();

        int minLen=slen+1;

        int l=0,r=0;

        for(char c : tc){
            tmap[c]++;
        }

        while (right<slen){
            if(tmap[sc[right]]>0){
                count--;
            }

            tmap[sc[right]]--;
            right++;

            //t 已经扫了一遍了
            while (count==0){
                if(right-left<minLen){
                    minLen = right-left;
                    l=left;
                    r=right;
                }

                tmap[sc[left]]++;
                //说明 tmap[sc[left]] 这个位置 还有每匹配的
                if(tmap[sc[left]]>0){
                    count++;
                }
                left++;
            }
        }
        return minLen==slen+1?"":s.substring(l,r);

    }

}
