package cn.bw.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class L39组合总和 {

    public List<List<Integer>> combinationSum(int[] candidates,
                                              int target) {
        List<List<Integer>> rs = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        backtrack(candidates,target,0,path,rs);
        return rs;

    }

    private void backtrack(int[] nums,
                           int target,
                           int idx,
                           Deque<Integer> path,
                           List<List<Integer>> rs){

        if(target==0){
            rs.add(new ArrayList<>(path));
            return;
        }

        for(int i=idx;i<nums.length;i++){
            if(nums[i]>target){
                continue;
            }

            path.add(nums[i]);
            backtrack(nums,target-nums[i],i,path,rs);
            path.removeLast();
        }

    }
}
