class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> tracker = new HashSet<>();
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            int window = right - left;
            if (window > k) {
                tracker.remove(nums[left]);
                left++;
                continue;
            }
            if (tracker.contains(nums[right])) {
                return true;
            }
            tracker.add(nums[right]);
            right++;
        }
        return false;
    }
}