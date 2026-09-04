class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int window = nums.length + 1;
        int left = 0;
        int right = 0;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                window = Math.min(window, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return window == nums.length + 1 ? 0 : window;
    }
}