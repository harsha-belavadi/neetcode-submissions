class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();        
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        int n = nums.length/2;
        int maxMajority = Integer.MIN_VALUE;
        int k = -1;       
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            if (entry.getValue() >= n && entry.getValue() >= maxMajority) {
                maxMajority = entry.getValue();
                k = entry.getKey();
            }
        }

        return k;
    }
}