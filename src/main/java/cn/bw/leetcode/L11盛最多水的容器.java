package cn.bw.leetcode;

public class L11盛最多水的容器 {

    public int maxArea(int[] height) {
        int len=height.length;
        int l=0,r=len-1, ans=0;
        while (l<r){
            int w = r-l;
            int h=0;
            if(height[l]<height[r]){
                h = height[l];
                l++;
            }else {
                h=height[r];
                r--;
            }
            ans = Math.max(w*h,ans);
        }
        return ans;

    }
}
