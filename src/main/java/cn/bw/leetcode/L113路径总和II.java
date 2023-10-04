package cn.bw.leetcode;

import cn.bw.leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class L113路径总和II {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> rs = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        dfs(root, 0,targetSum, path, rs);

        return rs;
    }

    private void dfs(TreeNode node,
                     int cur,
                     int target,
                     Deque<Integer> path,
                     List<List<Integer>> rs) {
        if(node==null)return;

        cur += node.val;
        path.add(node.val);
        if(node.left==null && node.right==null && cur==target){
            rs.add(new ArrayList<>(path));
        }

        dfs(node.left,cur,target,path,rs);
        dfs(node.right,cur,target,path,rs);
        cur -= node.val;
        path.removeLast();


    }


}
