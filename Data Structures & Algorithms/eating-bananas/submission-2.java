class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxi = piles[0];
        for (int i=1; i<piles.length; i++) { maxi = Math.max(maxi, piles[i]); }
        
        int low = 1;
        int high = maxi;
        int minBananas = maxi;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int hours = calculate(piles, mid);
            if (hours <= h) {
                minBananas = Math.min(minBananas, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return minBananas;
    }

    private int calculate(int[] piles, int bananas) {
        int hours = 0;
        for (int p : piles) {
            hours += (int)(Math.ceil((double)p/bananas));
        }
        return hours;
    }
}
