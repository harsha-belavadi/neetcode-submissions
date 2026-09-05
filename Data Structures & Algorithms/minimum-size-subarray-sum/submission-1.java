class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int sum = 0;
        int left = 0;
        int right = 0;
        int minLength = n + 1;
        while (right < n) {
            sum += nums[right];
            int window = right - left + 1;
            while (sum >= target) {
                minLength = Math.min(minLength, window);
                sum -= nums[left];
                left++;
                window = right - left + 1;
            }            
            right++;
        }
        return minLength == n + 1 ? 0 : minLength;
    }
}