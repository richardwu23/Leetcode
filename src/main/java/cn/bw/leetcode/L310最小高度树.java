package cn.bw.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L310最小高度树 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Integer> res = new LinkedList<>();
        if(n==1){
            res.add(0);
            return res;
        }

        int[] degree = new int[n];
        List<Integer>[] adj = new List[n];
        for(int i=0;i<n;i++){
            adj[i]=new LinkedList<>();
        }

        for(int[] edge:edges){
            degree[edge[0]]++;
            degree[edge[1]]++;

            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<n;i++){
            if(degree[i]==1){
                queue.add(i);
            }
        }

        int remain=n;
        while (remain>2){
            int size=queue.size();
            remain -=size;

            for(int i=0;i<size;i++){
                int cur = queue.poll();
                for(int ad:adj[cur]){
                    degree[ad]--;
                    if(degree[ad]==1){
                        queue.offer(ad);
                    }
                }
            }

        }


        while (!queue.isEmpty()){
            int cur = queue.poll();
            res.add(cur);
        }
        return res;


    }
}
