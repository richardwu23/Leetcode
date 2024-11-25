package cn.bw.leetcode;

public class L53最大子数组和 {

    //dp 解法， 遍历数组， 如果 sum >0 则对结果有增益，如果sum<=0
    // 则等于当前元素
    public int maxSubArray(int[] nums) {
        int len=nums.length, ans=nums[0],sum =0;
        for(int i=0;i<len;i++){
            if(sum>0){
                sum += nums[i];
            }else {
                sum = nums[i];
            }
            ans = Math.max(ans,sum);

        }
        return ans;

    }

}
