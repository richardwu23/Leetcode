package cn.bw.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class L78子集 {

    public List<List<Integer>> subsets(int[] nums) {
        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> rs = new ArrayList<>();

        backtrack(nums,0,path,rs);
        return rs;

    }

    private void backtrack(int[] nums,
                           int idx,
                           Deque<Integer> path,
                           List<List<Integer>> rs){
        rs.add(new ArrayList<>(path));
        if(idx==nums.length){
            return;
        }

        for(int i=idx;i<nums.length;i++){

            path.add(nums[i]);
            backtrack(nums,i+1,path,rs);
            path.removeLast();

        }
    }

}
