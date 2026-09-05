class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> numset = new HashSet<>();
        int n = nums.length;
        int left = 0;
        int right = 0;
        while (right < n) {
            if (right - left <= k) {
                if (numset.contains(nums[right])) {
                    return true;
                }
                numset.add(nums[right]);
                right++;
            } else {
                while (right - left > k) {
                    numset.remove(nums[left]);
                    left++;
                }
            }
        }
        return false;
    }
}