class Solution {
    public int findDuplicate(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            int index = Math.abs(nums[i]);
            // If already negative, the value is already seen
            if (nums[index - 1] < 0) return index;
            nums[index - 1] *= -1;
        }
        return -1;
    }
}
