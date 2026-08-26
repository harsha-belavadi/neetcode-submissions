class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> track = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            int n = nums[i];
            int diff = target - n;
            if (track.containsKey(diff)) {
                return new int[] { track.get(diff), i };
            }
            track.put(n, i);
        }

        return new int[] { -1, -1 };
    }
}
