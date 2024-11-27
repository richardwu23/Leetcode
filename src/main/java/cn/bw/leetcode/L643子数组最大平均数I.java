package cn.bw.leetcode;

public class L643子数组最大平均数I {
    public double findMaxAverage(int[] nums, int k) {
        double sum=0, avg = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(i<k-1){
                continue;
            }
            avg = Math.max(avg,sum/k);
            sum -= nums[i-k+1];
        }

        return avg;

    }
}
