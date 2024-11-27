package cn.bw.leetcode;

public class L55跳跃游戏 {
    public boolean canJump(int[] nums) {
        int len=nums.length, maxPos=0;

        for(int i=0;i<len;i++){
            if(i<=maxPos){
                maxPos = Math.max(maxPos,nums[i]+i);
                if(maxPos>=(len-1)){
                    return true;
                }

            }
        }

        return false;
    }
}
