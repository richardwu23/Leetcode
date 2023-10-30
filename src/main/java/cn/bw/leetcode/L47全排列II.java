package cn.bw.leetcode;

import java.util.*;

public class L47全排列II {

    public List<List<Integer>> permuteUnique(int[] nums) {
        //notice:  sort
        Arrays.sort(nums);
        List<List<Integer>> rs = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] v = new boolean[nums.length];
        backtrack(nums,0,v,path,rs);
        return rs;
    }

    private void backtrack(int[] nums,
                           int idx,
                           boolean[] v,
                           Deque<Integer> path,
                           List<List<Integer>> rs){
        if(idx==nums.length){
            rs.add(new ArrayList<>(path));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(v[i] || i>0&&nums[i]==nums[i-1]&& !v[i-1]){
                continue;
            }

            path.add(nums[i]);
            v[i]=true;
            backtrack(nums,idx+1, v, path, rs);
            v[i]=false;
            path.removeLast();
        }
    }
}
