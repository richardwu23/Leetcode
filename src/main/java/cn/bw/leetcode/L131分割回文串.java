package cn.bw.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class L131分割回文串 {

    public List<List<String>> partition(String s) {
        Deque<String> path =new ArrayDeque<>();
        List<List<String>> rs = new ArrayList<>();
        backtrack(s,path,rs);
        return rs;

    }


    private void backtrack(String s,
                           Deque<String> path,
                           List<List<String>> rs){
        if(s==null||s.length()==0)
            rs.add(new ArrayList<>(path));

        for(int i=1;i<=s.length();i++){
            if(isPali(s.substring(0,i))){
                path.add(s.substring(0,i));
                backtrack(s.substring(i,s.length()),path,rs);
                path.removeLast();
            }
        }
    }

    private boolean isPali(String s){
        int left=0, right=s.length()-1;

        while (left<right){
            if(s.charAt(left)!=s.charAt(right))
                return false;

            left++;
            right--;
        }
        return true;
    }



}
