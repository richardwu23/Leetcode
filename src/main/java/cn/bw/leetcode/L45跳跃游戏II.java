package cn.bw.leetcode;

public class L45跳跃游戏II {

    public int jump(int[] nums) {
        int len=nums.length, steps=0, maxPos=0, end=0;

        for(int i=0;i<len-1;i++){
            maxPos = Math.max(maxPos, nums[i]+i);
            if(i==end){
                end = maxPos;
                steps++;
            }

        }

        return steps;
    }

}
