package cn.bw.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class L239滑动窗口最大值 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len=nums.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int[] rs = new int[len-k+1];

        for(int i=0;i<len;i++){

            while (!deque.isEmpty() && nums[deque.peekLast()]<=nums[i]){
                deque.pollLast();
            }
            deque.add(i);

            if(i-k+1>deque.peekFirst()){
                deque.pollFirst();
            }

            if(i-k+1>=0){
                rs[i-k+1]=nums[deque.peekFirst()];
            }

        }

        return rs;
    }
}
