class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int result = Integer.MIN_VALUE;
        while (l < r) {
            int minHeight = Math.min(heights[l], heights[r]);
            int water = minHeight * (r - l);
            result = Math.max(result, water);
            if (heights[l] < heights[r]) { l++; }
            else { r--; }
        }
        return result;
    }
}
