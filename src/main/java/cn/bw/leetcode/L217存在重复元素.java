package cn.bw.leetcode;

import java.util.HashSet;
import java.util.Set;

public class L217存在重复元素 {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            if(set.contains(n)){
                return true;
            }
            set.add(n);
        }
        return false;
    }
}
