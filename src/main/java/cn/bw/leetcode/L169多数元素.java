package cn.bw.leetcode;

public class L169多数元素 {


    //解法： 摩尔投票
    //
    public int majorityElement(int[] nums) {
        int x = 0, votes = 0;
        for (int num : nums){
            if (votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }


}
