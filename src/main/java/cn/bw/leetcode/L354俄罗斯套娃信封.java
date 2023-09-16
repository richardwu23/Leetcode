package cn.bw.leetcode;

import java.util.Arrays;

public class L354俄罗斯套娃信封 {

    public int maxEnvelopes(int[][] envelopes) {

        int len=envelopes.length;
        Arrays.sort(envelopes,(a,b)->a[0]==b[0]?
                b[1]-a[1]:a[0]-b[0]);

        int[] height= new int[len];

        for(int i=0;i<len;i++){
            height[i]=envelopes[i][1];
        }

        return getPiles(height);
    }

    public int getPiles(int[] height){
        int len=height.length;
        int piles=0;
        int[] tops = new int[len];

        for(int i=0;i<len;i++){
            int cur=height[i];
            int left=0,right=piles;
            while (left<right){
                int mid = (left+right)>>1;
                if(tops[mid]>=cur){
                    right=mid;
                }else{
                    left=mid+1;
                }
            }
            if(left==piles){
                piles++;
            }

            tops[left]=cur;

        }
        return piles;
    }
}
