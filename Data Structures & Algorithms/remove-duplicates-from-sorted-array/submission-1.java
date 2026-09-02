class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int k = 0;
        int left = 0;
        int right = 0;
        while (right < n) {
            nums[k] = nums[right];
            k++;
            while (right < n && nums[left] == nums[right]) {
                right++;
            }
            left = right;
        }
        return k;
    }
}