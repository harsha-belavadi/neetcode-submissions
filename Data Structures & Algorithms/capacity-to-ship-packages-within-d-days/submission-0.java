class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxWt = 0;
        int sum = 0;
        for (int n : weights) {
            maxWt = Math.max(maxWt, n);
            sum += n;
        }
        int low = maxWt;
        int high = sum;
        int least = maxWt;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int d = getDays(weights, mid);
            if (d <= days) {
                least = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return least;
    }

    private int getDays(int[] wt, int cap) {
        int days = 1;
        int load = 0;
        for (int w : wt) {
            if (load + w > cap) {
                days++;
                load = w;
            } else {
                load += w;
            }
        }
        return days;
    }
}