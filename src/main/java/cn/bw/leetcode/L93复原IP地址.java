package cn.bw.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class L93复原IP地址 {


    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new LinkedList<>();
        if(s.length()<4 || s.length()>12)return ans;
        Deque<String> path = new LinkedList<>();
        backtrack(s,0,path,ans);
        return ans;

    }

    void backtrack(String s,
                   int start,
                   Deque<String> path,
                   List<String> ans){
        //ip 4段
        if(path.size()==4){
            if(start==s.length()){
                ans.add(String.join(".",path));
            }
            return;
        }

        //0 - 255， 最多取3个字符
        for(int len=1;len<=3;len++){
            //注意此判断条件
            if(start+len> s.length())break;

            String sub = s.substring(start,start+len);

            if(isValid(sub)){
                path.add(sub);
                backtrack(s,start+len,path,ans);
                path.removeLast();
            }

        }


    }

    boolean isValid(String sub){
        //注意 >1
        if(sub.length()>1 && sub.startsWith("0")){
            return false;
        }

        int num = Integer.parseInt(sub);
        return num>=0 && num<=255;
    }
}
