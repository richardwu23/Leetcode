package cn.bw.leetcode;

import java.util.*;

public class L90子集II {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> rs = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        backtrack(nums,0,path,rs);
        return rs;
    }

    private void backtrack(int[] nums,
                           int idx,
                           Deque<Integer> path,
                           List<List<Integer>> rs){
        rs.add(new ArrayList<>(path));
        if(path.size()==nums.length)return;

        for(int i=idx;i<nums.length;i++){

            if(i>idx&&nums[i]==nums[i-1]){
                continue;
            }

            path.add(nums[i]);
            backtrack(nums, i+1, path, rs);
            path.removeLast();

        }
    }

}
