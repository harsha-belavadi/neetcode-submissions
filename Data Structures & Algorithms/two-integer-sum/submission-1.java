class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> diffMap = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            int diff = target - nums[i];
            if (diffMap.containsKey(diff)) {
                return new int[] { diffMap.get(diff), i };
            }
            diffMap.put(nums[i], i);
        }
        return new int[] { -1, -1 };
    }
}
