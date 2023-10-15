package cn.bw.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class L46全排列 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rs = new LinkedList<>();
        Deque<Integer> path=new LinkedList<>();
        backtrack(nums,path,rs,new boolean[nums.length]);
        return rs;

    }

    private void backtrack(int[] nums,
                           Deque<Integer> path,
                           List<List<Integer>> rs,
                           boolean[] v){
        if(path.size()==nums.length){
            rs.add(new LinkedList<>(path));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(!v[i]){
                path.add(nums[i]);
                v[i]=true;
                backtrack(nums,  path, rs, v);
                v[i]=false;
                path.removeLast();
            }
        }
    }
}
