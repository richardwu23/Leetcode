package cn.bw.leetcode;

import java.util.*;

public class L40组合总和II {
    public List<List<Integer>> combinationSum2(int[] candidates,
                                               int target) {
        Arrays.sort(candidates);
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
            if(nums[i]>target)continue;
            if(i>idx &&nums[i]==nums[i-1]) continue;
            path.add(nums[i]);
            backtrack(nums, target-nums[i], i+1, path, rs);
            path.removeLast();
        }
    }
}
