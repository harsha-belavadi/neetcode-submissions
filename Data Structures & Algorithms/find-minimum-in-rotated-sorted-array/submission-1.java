class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int minimum = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // left sorted
            if (nums[low] <= nums[mid]) {
                minimum = Math.min(minimum, nums[low]);
                low = mid + 1;
            } 
            // right sorted -> since a sorted array is rotated, one side is guarenteed to be sorted
            // hence using else instead of defining condition
            else {
                minimum = Math.min(minimum, nums[mid]);
                high = mid - 1;
            }
        }
        return minimum;
    }
}
