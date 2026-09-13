class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int sum = 0;
        int min = n + 1;
        while (right < n) {
            sum += nums[right];
            int window = right - left + 1;
            while (sum >= target) {
                min = Math.min(min, window);
                sum -= nums[left];
                left++;
                window = right - left + 1;                
            }
            right++;
        }
        return min == n + 1 ? 0 : min;
    }
}