class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixCounter = new HashMap<>() {{ put(0, 1); }};
        int prefix = 0;
        int count = 0;
        for (int num : nums) {
            prefix += num;
            int diff = prefix - k;
            if (prefixCounter.containsKey(diff)) { count += prefixCounter.get(diff); }
            prefixCounter.put(prefix, prefixCounter.getOrDefault(prefix, 0) + 1);
        }
        return count;
    }
}