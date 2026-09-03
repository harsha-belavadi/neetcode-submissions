class Solution {
    public int maxProfit(int[] prices) {
        // Prefix Min Element to left =>
        // prefix: Min(prefix[i-1], prices[i])
        // We can use min variable instead of prefix array
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i=1; i<prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i-1]); // Buy
            maxProfit = Math.max(maxProfit, prices[i] - minPrice); // Sell on ith day
        }
        return maxProfit;
    }
}
