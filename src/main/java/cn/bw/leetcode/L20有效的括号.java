package cn.bw.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import static javax.swing.UIManager.put;

public class L20有效的括号 {

    /**
     *  //对于每个字符 c，首先判断它是否是一个左括号（即 map.containsKey(c)）。
     *         //如果是左括号，说明需要将其压入栈中，继续进行下一步检查。
     *         //如果是右括号，则需要从栈中弹出一个元素，并检查这个弹出的元素对应的右括号是否与当前字符 c 匹配。
     *         //如果不匹配，说明括号不匹配，返回 false。
     */
    public boolean isValid(String s) {

        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');

        //判断 首个字符 是否是 左括号
        if(s.length()>0 && !map.containsKey(s.charAt(0)))return false;
        LinkedList<Character> stack = new LinkedList<>();
        for(Character c : s.toCharArray()){
            if(map.containsKey(c)){
                stack.addLast(c);
            }else {
                //注意
                if(stack.isEmpty())return false;
                Character last=stack.pollLast();
                if(map.get(last)!=c){
                    return false;
                }
            }
        }
        //注意
        return stack.isEmpty();
    }

}
