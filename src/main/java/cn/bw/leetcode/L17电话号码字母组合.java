package cn.bw.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L17电话号码字母组合 {

    public List<String> letterCombinations(String digits) {

        List<String> results=new ArrayList<>();
        if(digits==null||digits.length()==0){
            return results;
        }
        Map<Character,String> map = new HashMap<Character,String>(){{
            put('2',"abc");
            put('3',"edf");
            put('4',"ghi");
            put('5',"jkl");
            put('6',"mno");
            put('7',"pqrs");
            put('8',"tuv");
            put('9',"wxyz");
        }};

        backtrack(digits,0,map,new StringBuilder(),results);

        return results;

    }


    private void backtrack(String digits,
                           int idx,
                           Map<Character, String> map,
                           StringBuilder sb,
                           List<String> res) {

        if(idx==digits.length()){
            res.add(sb.toString());
            return;
        }else {
            char c = digits.charAt(idx);
            String letters = map.get(c);
            for(int i=0;i<letters.length();i++){
                sb.append(letters.charAt(i));
                backtrack(digits, idx+1, map, sb, res);
                sb.deleteCharAt(idx);
            }
        }



    }

}
