package cn.bw.leetcode;

public class L122买卖股票最佳时机II {

    public int maxProfit(int[] prices) {
        int profit = 0, len=prices.length;

        for(int i=1;i<len;i++){
            if(prices[i]>prices[i-1]){
                profit += prices[i]-prices[i-1];
            }
        }

        return profit;

    }
}
