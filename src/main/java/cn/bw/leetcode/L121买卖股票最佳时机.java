package cn.bw.leetcode;

public class L121买卖股票最佳时机 {


    public int maxProfit(int[] prices) {
        int len=prices.length;
        int low = prices[0];
        int ans = 0;
        for(int i=1;i<len;i++){
            if(prices[i]<low){
                low = prices[i];
            }else {
                ans = Math.max(ans, prices[i]-low);
            }

        }
        return ans;

    }

}
