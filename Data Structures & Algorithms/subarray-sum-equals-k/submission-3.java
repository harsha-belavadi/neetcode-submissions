class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixMap = new HashMap<>() {{
            put(0, 1);
        }};
        int count = 0;
        int prefixSum = 0;
        for (int n : nums) {
            prefixSum += n;
            int diff = prefixSum - k;
            if (prefixMap.containsKey(diff)) {
                count += prefixMap.get(diff);
            }
            prefixMap.put(prefixSum, prefixMap.getOrDefault(prefixSum, 0)+1);
        }
        return count;
    }
}