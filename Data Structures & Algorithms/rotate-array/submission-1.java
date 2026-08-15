class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length - 1;
        k = k % nums.length;
        rotate(nums, 0, n);
        rotate(nums, 0, k-1);
        rotate(nums, k, n);
    }

    private int[] rotate(int[] nums, int l, int r) {
        while (l < r) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
        return nums;
    }
}