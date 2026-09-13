class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        int left = 0;
        int right = 0;
        while (right < n) {
            int window = right - left;
            if (window <= k) {
                if (set.contains(nums[right])) {
                    return true;
                }
                set.add(nums[right]);
                right++;
            } else {                
                while (window > k) {
                    window = right - left;
                    set.remove(nums[left]);
                    left++;
                }
            }
        }
        return false;
    }
}