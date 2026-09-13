class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        while (right < n) {
            if (nums[right] == val) {
                right++;
                continue;
            }
            nums[left] = nums[right];
            left++;
            right++;
        }
        return left;
    }
}