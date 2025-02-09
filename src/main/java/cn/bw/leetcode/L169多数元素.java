package cn.bw.leetcode;

public class L169多数元素 {


    //解法： 摩尔投票原理：
    //每次遇到与当前候选相同的元素时，增加投票数。
    //每次遇到与当前候选不同的元素时，减少投票数。
    //多数元素的数量超过其他元素的总和，
    // 因此在投票数归零之前，多数元素始终会被选为候选。
    public int majorityElement(int[] nums) {
        int x = 0, votes = 0;
        for (int num : nums){
            if (votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }


}
