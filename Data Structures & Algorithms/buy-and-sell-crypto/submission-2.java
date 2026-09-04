class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int minBuy = prices[0];
        for (int i=1; i<prices.length; i++) {
            minBuy = Math.min(minBuy, prices[i-1]);
            profit = Math.max(profit, prices[i] - minBuy);
        }
        return profit;
    }
}
