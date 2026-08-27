class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        int maxMajority = Integer.MIN_VALUE;
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
            maxMajority = Math.max(maxMajority, counter.get(num));
        }

        int n = nums.length/2;        
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            if (entry.getValue() >= n/2 && entry.getValue() == maxMajority) {
                return entry.getKey();
            }
        }

        return -1;
    }
}