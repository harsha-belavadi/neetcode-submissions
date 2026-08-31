class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) { return 1; }
        
        int n = nums.length;
        int left = 0;
        int right = 0;
        int k = 0;
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