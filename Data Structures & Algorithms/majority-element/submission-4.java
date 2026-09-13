class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int n : nums) {
            counter.put(n, counter.getOrDefault(n, 0) + 1);
        }
        int result = 0;
        int n = nums.length;
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (value > n/2) {
                result = key;
                break;
            }
        }
        return result;
    }
}