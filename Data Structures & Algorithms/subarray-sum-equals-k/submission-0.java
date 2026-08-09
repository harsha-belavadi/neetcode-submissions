class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixCounter = new HashMap<>() {{
            put(0, 1);
        }};
        int prefixSum = 0;
        int count = 0;
        for (int n : nums) {
            prefixSum += n;
            int diff = prefixSum - k;
            count += prefixCounter.getOrDefault(diff, 0);
            prefixCounter.put(prefixSum, prefixCounter.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}