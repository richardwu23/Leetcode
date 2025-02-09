package cn.bw.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class L216组合总和III {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new LinkedList<>();
        Deque<Integer> path = new LinkedList<>();
        backtrack(n,k,1,path,ans);
        return ans;

    }

    void backtrack(int n, int k,
                   int cur,
                   Deque<Integer> path,
                   List<List<Integer>> ans){

        if(path.size()==k&&n==0){
            ans.add(new LinkedList<>(path));
            return;
        }
        if(path.size()>k||n<0){
            return;
        }
        for(int i=cur;i<=9;i++){
            path.add(i);
            backtrack(n-i, k, i+1, path, ans);
            path.removeLast();
        }

    }
}
