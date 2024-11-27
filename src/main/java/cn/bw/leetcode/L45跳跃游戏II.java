package cn.bw.leetcode;

public class L45跳跃游戏II {

    public int jump(int[] nums) {
        int len=nums.length, steps=0, maxPos=0, end=0;
        // 为什么是 i < len - 1 而不是 i < len？
        //这是因为在跳跃游戏中，终点是数组的最后一个元素，
        // 而我们不需要在数组的最后一个位置再进行跳跃判断。
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
