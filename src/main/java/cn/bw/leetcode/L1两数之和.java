package cn.bw.leetcode;

import java.util.HashMap;
import java.util.Map;

public class L1两数之和 {
    public int[] twoSum(int[] nums, int target) {
        int len=nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<len;i++){
            int cur = nums[i];
            int rest = target-cur;
            if(map.containsKey(rest)){
                return new int[]{i,map.get(rest)};
            }

            map.put(cur,i);
        }

        return new int[0];
    }

}
