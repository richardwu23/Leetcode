package cn.bw.leetcode;

public class L42接雨水 {

    /**
     * 双指针
     * 左右，看哪一侧的低，更新低的一侧
     */
    public int trap(int[] height) {
        //左右 指针
        int left=0,right=height.length-1;
        //左右 柱子 最高度
        int leftMax=0,rightMax=0;
        int ans =0;

        while (left<right){
            if(height[left]<height[right]){
                if(height[left]>leftMax){
                    leftMax =height[left];
                }else {
                    // 当前柱子能接的雨水量为：左侧最高高度 - 当前柱子高度
                    ans += leftMax-height[left];
                }
                left++;
            }else {
                if(height[right]>rightMax){
                    rightMax=height[right];
                }else {
                    // 当前柱子能接的雨水量为：右侧最高高度 - 当前柱子高度
                    ans += rightMax-height[right];
                }
                right--;
            }
        }
        return ans;

    }

    public int trap0(int[] height) {
        int len = height.length; // 数组的长度（柱子总数）

        // 初始化两个数组，用于记录每个位置左右方向的最高柱子高度
        int[] left = new int[len];  // 记录从左向右扫描时每个位置的最高柱子高度
        int[] right = new int[len]; // 记录从右向左扫描时每个位置的最高柱子高度

        // 第一个位置的左侧最高高度就是自身高度
        left[0] = height[0];
        // 最后一个位置的右侧最高高度就是自身高度
        right[len - 1] = height[len - 1];

        // 从左向右遍历，计算每个位置的左侧最高柱子高度
        for (int i = 1; i < len; i++) {
            left[i] = Math.max(height[i], left[i - 1]);
            // 当前柱子的左侧最高高度是：当前柱子高度与前一个位置的最高高度的较大值
        }

        // 从右向左遍历，计算每个位置的右侧最高柱子高度
        for (int i = len - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
            // 当前柱子的右侧最高高度是：当前柱子高度与后一个位置的最高高度的较大值
        }

        // 初始化接住雨水总量
        int ans = 0;

        // 遍历所有柱子，计算每个柱子处能接的雨水量
        for (int i = 0; i < len; i++) {
            ans += Math.min(left[i], right[i]) - height[i];
            // 当前位置能接住的雨水量 = 左右最高柱子的较小值 - 当前柱子的高度
            // 如果该值为负，说明当前位置不能接住雨水
        }

        return ans; // 返回接住的雨水总量
    }

}
