package cn.bw.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class L239滑动窗口最大值 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len=nums.length;
        //len-k+1 表示 共有多少个窗口值
        int[] ans = new int[len-k+1];
        //存 数组序号
        Deque<Integer> deque = new LinkedList<>();

        for(int i=0;i<len;i++){
            while (!deque.isEmpty() && nums[deque.peekLast()]<=nums[i]){
                deque.pollLast();
            }
            deque.offer(i);
            //i-k+1 窗口的左边界
            if(i-k+1 > deque.peekFirst()){
                deque.pollFirst();
            }
            if(i-k+1>=0){
                ans[i-k+1]=nums[deque.peekFirst()];
            }
        }
        return ans;


    }

}
