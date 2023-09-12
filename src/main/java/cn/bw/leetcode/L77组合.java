package cn.bw.leetcode;

import java.util.*;

//https://leetcode.cn/problems/combinations/solutions/13436/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-ma-/
public class L77组合 {



    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results=new ArrayList<>();
        if(n<k || n<=0){
            return  results;
        }

        Deque<Integer> path = new ArrayDeque<>();
        dfs(n,k,1,path,results);
        return results;

    }

    private void dfs(int n, int k, int start, Deque<Integer> path, List<List<Integer>> results){
        if(path.size()==k){
            results.add(new LinkedList<Integer>(path));
            return;
        }

        for(int i=start;i<=n;i++){
            path.addLast(i);
            dfs(n,k,i+1,path,results);
            path.removeLast();
        }

    }

}
