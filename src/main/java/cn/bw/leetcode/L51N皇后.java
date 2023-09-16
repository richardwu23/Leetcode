package cn.bw.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class L51N皇后 {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] q= new int[n];
        backtrack(q,0,res);
        return res;
    }

    private void backtrack(int[] q, int pos,List<List<String>> res){
        int len=q.length;
        if(pos==len){
            List<String> r = new ArrayList<>();
            for(int i=0;i<len;i++){
                StringBuilder sb = addPoints(len);
                sb.setCharAt(q[i],'Q');
                r.add(sb.toString());
            }
            res.add(r);
            return;
        }

        for(int i=0;i<len;i++){
            q[pos]=i;
            if(isValid(q,pos)){
                backtrack(q, pos+1, res);
            }
        }

    }

    private boolean isValid(int[] q, int pos){

        for(int i=0;i<pos;i++){
            if(q[i]==q[pos]){
                return false;
            }
            if(Math.abs(i-pos)==Math.abs(q[i]-q[pos])){
                return false;
            }
        }
        return true;
    }

    private StringBuilder addPoints(int n){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(".");
        }
        return sb;
    }
}
