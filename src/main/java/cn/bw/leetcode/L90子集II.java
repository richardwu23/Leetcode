package cn.bw.leetcode;

import java.util.*;

public class L90子集II {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Deque<Integer> path = new LinkedList<>();
        List<List<Integer>> ans = new LinkedList<>();
        backtrack(nums,0,path,ans);
        return ans;
    }

    void backtrack(int[] nums,
                   int idx,
                   Deque<Integer> path,
                   List<List<Integer>> ans){
        ans.add(new LinkedList<>(path));
        if(idx==nums.length){
            return;
        }
        for(int i=idx;i< nums.length;i++){
            if(i>idx && nums[i]==nums[i-1])continue;
            path.add(nums[i]);
            backtrack(nums, i+1, path, ans);
            path.removeLast();
        }
    }

}
