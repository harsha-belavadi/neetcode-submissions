class Solution {
    public int firstMissingPositive(int[] nums) {
        // Solution will always be in range [1....len(Array) + 1]
        // We can mark indices using value - 1 to indicate that particular value is already exists in nums

        // Mark all < 0 values to 0
        for (int i=0; i<nums.length; i++) {
            if (nums[i] < 0) {
                nums[i] = 0;
            }
        }

        // Map values to indices - alternative to HashSet - any index which is positive will be the answer
        // as the answer lies in above mentioned range.
        for (int i=1; i<=nums.length; i++) {
            int val = Math.abs(nums[i-1]);
            if (val >= 1 && val <= nums.length) {
                if (nums[val - 1] > 0) {
                    nums[val - 1] *= -1;
                } 
                // This was earlier negative and marked to 0 in prev forloop
                else if (nums[val - 1] == 0) {
                    nums[val - 1] = -1 * (nums.length + 1);
                }
            }
        }

        for (int i=1; i<=nums.length; i++) {
            if (nums[i - 1] >= 0) {
                return i;
            }
        }

        return nums.length + 1;
    }
}