class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxbananas = 0;
        for (int p : piles) { maxbananas = Math.max(maxbananas, p); }
        int low = 1;
        int high = maxbananas;
        int minBananasPerHour = maxbananas;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int hours = calculate(piles, mid);
            if (hours <= h) {
                minBananasPerHour = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return minBananasPerHour;           
    }

    private int calculate(int[] piles, int bananas) {
        double hours = 0;
        for (int p : piles) {
            hours += Math.ceil(p / (double) bananas);
        }
        return (int) hours;
    }    
}
