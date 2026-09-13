class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int minPrice = prices[0];
        int profit = 0;
        for (int i=1; i<n; i++) {
            minPrice = Math.min(minPrice, prices[i-1]);
            profit = Math.max(profit, prices[i] - minPrice);
        }
        return profit;
    }
}
